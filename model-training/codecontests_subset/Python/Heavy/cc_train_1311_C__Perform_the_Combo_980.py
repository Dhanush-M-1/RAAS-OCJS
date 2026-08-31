from sys import stdin
for _ in range(int(stdin.readline().rstrip())):
    n, m = map(int, stdin.readline().rstrip().split(" "))
    s = list(stdin.readline().rstrip())
    l = list(map(int, stdin.readline().rstrip().split(" ")))
    r = [[0]*26 for i in range(n)]
    for i in range(1,n):
        z = i-1
        for j in range(26):
            r[i][j]+=r[i-1][j]
        r[i][ord(s[z])-97]+=1
    res = [0]*26
    for i in range(n):
        res[ord(s[i]) - 97] += 1

    for i in l:
        res = [sum(i) for i in zip(res, r[i])]
    print(*res)