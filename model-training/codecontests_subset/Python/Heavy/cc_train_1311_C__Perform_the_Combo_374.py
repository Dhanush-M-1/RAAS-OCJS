#Pye
from os import path
from sys import stdin, stdout
maxn = 200005
count = [[0 for j in range(26)] for i in range(maxn)]
if path.exists('inp.txt'): stdin = open("inp.txt", "r")
q = int(stdin.readline())
for _ in range(q):
    n, m = map(int, stdin.readline().split())
    inp = stdin.readline().split(); s = inp[0]
    a = list(map(int, stdin.readline().split()))
    ans = [0 for i in range(26)]
    for i in range(len(s)):
        for j in range(26): count[i][j] = 0
    for i in range(len(s)):
        for j in range(26):
            count[i][j] = count[i-1][j]
            if ord(s[i]) - ord('a') == j: count[i][j] += 1
    for i in a:
        for j in range(26): ans[j] += count[i-1][j]
    for i in range(26): ans[i] += count[n-1][i]
    print(*ans)