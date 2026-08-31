import sys, string

def convert(ch):
    return ord(ch) - ord('a')

tc = int(sys.stdin.readline())
for _ in range(tc):
    n, m = map(int, sys.stdin.readline().split())
    arr = list(sys.stdin.readline().rstrip())
    res = [[0] * 26 for _ in range(n)]
    temp = list(map(int, sys.stdin.readline().split()))
    ans = [0] * 26
    res[0][convert(arr[0])] = 1
    for i in range(1, n):
        for j in range(26):
            res[i][j] = res[i - 1][j]
        res[i][convert(arr[i])] += 1
    for i in temp:
        for j in range(26):
            ans[j] += res[i - 1][j]
    for i in arr:
        ans[convert(i)] += 1
    print(' '.join(map(str, ans)))