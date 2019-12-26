package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int result = 0;
        Scanner lsc = new Scanner(System.in);

        String line;
        List<List<Integer>> mapList = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        while (lsc.hasNextLine()) {
            line = lsc.nextLine();
            Scanner sc = new Scanner(line).useDelimiter("\\s*");

            if (!line.equals("")) {
                while (sc.hasNextInt()) {
                    row.add(sc.nextInt());
                }
            } else {
                break;
            }
            mapList.add(row);
            row = new ArrayList<>();
        }

        Integer[][] map = mapList.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
        result = m.getMaxMinutes(map);
        System.out.println(result);
    }

    public int getMaxMinutes(Integer[][] map) {
        int maxMinutes = 0;

        List<int[]> programmerPositions = new ArrayList<>();

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == 2) {
                    programmerPositions.add(new int[]{r, c});
                }
            }
        }

        try {
            maxMinutes = bfs(map, programmerPositions);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == 1) {
                    return -1;
                }
            }
        }

        return maxMinutes;
    }

    private int bfs(Integer[][] map, List<int[]> positions) throws Exception {
        int depth = 0;
        while (true) {
            List<int[]> nextPositions = new ArrayList<>();
            for (int[] pos : positions) {
                if (!isValidPosition(map, pos[0], pos[1])) {
                    throw new Exception("invalid position");
                }

                int r = pos[0], c = pos[1];

                if (isValidPosition(map, r, c - 1) && map[r][c - 1] == 1) {
                    map[r][c - 1] = 2;
                    nextPositions.add(new int[]{r, c - 1});
                }
                if (isValidPosition(map, r, c + 1) && map[r][c + 1] == 1) {
                    map[r][c + 1] = 2;
                    nextPositions.add(new int[]{r, c + 1});
                }
                if (isValidPosition(map, r - 1, c) && map[r - 1][c] == 1) {
                    map[r - 1][c] = 2;
                    nextPositions.add(new int[]{r - 1, c});
                }
                if (isValidPosition(map, r + 1, c) && map[r + 1][c] == 1) {
                    map[r + 1][c] = 2;
                    nextPositions.add(new int[]{r + 1, c});
                }
            }

            if (nextPositions.size() > 0) {
                depth++;
                positions = nextPositions;
            } else {
                break;
            }
        }

        return depth;
    }

    private boolean isValidPosition(Integer[][] map, int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
    }
}
