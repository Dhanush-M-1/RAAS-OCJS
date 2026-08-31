from sys import stdin, stdout
from math import gcd
input = stdin.readline

for _ in range(int(input())):
    n = int(input())
    a = [input() for i in range(n)]
    ans = [(i, j) for i, j in [(0, 1), (1, 0), (n - 2, n - 1), (n - 1, n - 2)] if (a[i][j] == '0') ^ (min(i, j) == 0)]
    if len(ans) <= 2:
        print(len(ans))
        for i in ans:
            print(i[0] + 1, i[1] + 1)
    else:
        ans = [(i, j) for i, j in [(0, 1), (1, 0), (n - 2, n - 1), (n - 1, n - 2)] if (a[i][j] == '0') ^ (min(i, j) != 0)]
        print(len(ans))
        for i in ans:
            print(i[0] + 1, i[1] + 1)
        
