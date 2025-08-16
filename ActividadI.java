import java.util.*;

public class ActividadI {

    public static List<int[]> minimizeDFA(int n, List<String> alphabet, Set<Integer> finalStates, List<Map<String, Integer>> transitions) {
        // Partición inicial: finales y no finales
        List<Set<Integer>> partition = new ArrayList<>();
        partition.add(new HashSet<>(finalStates));
        Set<Integer> nonFinal = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!finalStates.contains(i)) {
                nonFinal.add(i);
            }
        }
        if (!nonFinal.isEmpty()) {
            partition.add(nonFinal);
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            List<Set<Integer>> newPartition = new ArrayList<>();

            for (Set<Integer> group : partition) {
                Map<String, Set<Integer>> splitMap = new HashMap<>();

                for (int state : group) {
                    List<Integer> signature = new ArrayList<>();
                    for (String symbol : alphabet) {
                        int nextState = transitions.get(state).get(symbol);
                        int blockIndex = 0;
                        for (int idx = 0; idx < partition.size(); idx++) {
                            if (partition.get(idx).contains(nextState)) {
                                blockIndex = idx;
                                break;
                            }
                        }
                        signature.add(blockIndex);
                    }
                    String key = signature.toString();
                    splitMap.putIfAbsent(key, new HashSet<>());
                    splitMap.get(key).add(state);
                }

                newPartition.addAll(splitMap.values());
                if (splitMap.size() > 1) {
                    changed = true;
                }
            }

            partition = newPartition;
        }

        // Extraer pares equivalentes
        List<int[]> pairs = new ArrayList<>();
        for (Set<Integer> group : partition) {
            List<Integer> sortedGroup = new ArrayList<>(group);
            Collections.sort(sortedGroup);
            for (int i = 0; i < sortedGroup.size(); i++) {
                for (int j = i + 1; j < sortedGroup.size(); j++) {
                    pairs.add(new int[]{sortedGroup.get(i), sortedGroup.get(j)});
                }
            }
        }

        // Orden lexicográfico
        pairs.sort((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        return pairs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine().trim());

        for (int c = 0; c < cases; c++) {
            int n = Integer.parseInt(sc.nextLine().trim());
            List<String> alphabet = Arrays.asList(sc.nextLine().trim().split(" "));

            Set<Integer> finalStates = new HashSet<>();
            String[] finals = sc.nextLine().trim().split(" ");
            for (String f : finals) {
                if (!f.isEmpty()) {
                    finalStates.add(Integer.parseInt(f));
                }
            }

            List<Map<String, Integer>> transitions = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().trim().split(" ");
                Map<String, Integer> map = new HashMap<>();
                for (int j = 0; j < alphabet.size(); j++) {
                    map.put(alphabet.get(j), Integer.parseInt(row[j]));
                }
                transitions.add(map);
            }

            List<int[]> pairs = minimizeDFA(n, alphabet, finalStates, transitions);

            // Imprimir en formato requerido
            List<String> output = new ArrayList<>();
            for (int[] p : pairs) {
                output.add("(" + p[0] + ", " + p[1] + ")");
            }
            System.out.println(String.join(" ", output));
            }

        sc.close();
    }
}


