from sys import stdin
import math
n = int(input())
matrix = stdin.read().splitlines()
# hex2bin_map = {
#     "0": "0000",
#     "1": "0001",
#     "2": "0010",
#     "3": "0011",
#     "4": "0100",
#     "5": "0101",
#     "6": "0110",
#     "7": "0111",
#     "8": "1000",
#     "9": "1001",
#     "A": "1010",
#     "B": "1011",
#     "C": "1100",
#     "D": "1101",
#     "E": "1110",
#     "F": "1111",
# }
# grid = [''.join(hex2bin_map[i] for i in line) for line in matrix]
grid = [bin(int(i, 16))[2:].zfill(n) for i in matrix]
dx = [True] * n
dy = [True] * n
for i in range(n - 1):
    if grid[i] != grid[i + 1]:
        dy[i] = False
for i in range(n - 1):
    flag = True
    for j in range(n):
        if grid[j][i] != grid[j][i + 1]:
            flag = False
            break
    dx[i] = flag

ans = 1
for x in range(n, 0, -1):
    if n % x == 0:
        flag = True
        for i in range(n):
            if i % x == x - 1:
                continue
            if not dx[i] or not dy[i]:
                flag = False
                break
        if flag:
            ans = x
            break
print(ans)