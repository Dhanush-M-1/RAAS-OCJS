import sys

for _ in range(int(sys.stdin.readline().rstrip())):
    n, m = list(map(int, sys.stdin.readline().rstrip().split()))
    s = sys.stdin.readline().rstrip()
    p = list(map(int, sys.stdin.readline().rstrip().split()))
    chk = []
    for i in range(n):
        if i == 0:
            chk.append([0] * 26)
        else:
            chk.append(chk[i-1].copy())
        chk[i][ord(s[i]) - ord('a')] += 1
    re = [0] * 26
    for i in p:
        for j in range(26):
            re[j] += chk[i - 1][j]
    for idx, i in enumerate(re):
        print(i + chk[n - 1][idx], end=' ')
    print('')



