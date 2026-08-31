from collections import *

a = ord('a')
for i in range(int(input())):
    n, m = map(int, input().split())
    s, p = input(), list(map(int, input().split()))
    mem, ans = defaultdict(lambda: [0]), defaultdict(int)

    for k in s:
        for j in range(26):
            tem = mem[chr(a + j)][-1]
            if k == chr(a + j):
                tem += 1
            mem[chr(a + j)].append(tem)

    for k in range(m + 1):
        for j in range(26):
            if k < m:
                ans[chr(a + j)] += mem[chr(a + j)][p[k]]
            else:
                ans[chr(a + j)] += mem[chr(a + j)][-1]
                print(ans[chr(a + j)], end=' ')
    print(end='\n')
