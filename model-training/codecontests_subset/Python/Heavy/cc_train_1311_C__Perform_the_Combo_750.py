from collections import defaultdict
from sys import stdin


def convert(char):
    return ord(char) - 97


for _ in range(int(stdin.readline())):
    ans = [0 for i in range(26)]
    n, m = map(int, stdin.readline().split())
    s = input()
    p = list(map(int, stdin.readline().split()))
    strings = defaultdict(list)
    temp = [0 for i in range(26)]
    for i in range(n):
        temp[convert(s[i])] += 1
        strings[i] = tuple(temp)
    for i in p:
        for j in range(26):
            ans[j] += strings[i - 1][j]
    for i in range(26):
        ans[i] += strings[n-1][i]
    print(*ans)
