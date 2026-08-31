import sys
from sys import stdin

tt = int(stdin.readline())
ANS = []

for loop in range(tt):

    n = int(stdin.readline())
    r = list(map(int,stdin.readline().split()))
    c = list(map(int,stdin.readline().split()))
    r.sort()
    c.sort()

    if not r[0] == c[0] == 1:
        r.append(1)
        c.append(1)

    dic = {}

    maxl = 0
    for i in range(len(r)):
        maxl = max(maxl , r[i]-c[i])
        if (r[i] + c[i]) % 2 == 0:
            if r[i]-c[i] not in dic:
                dic[r[i]-c[i]] = []
            dic[r[i]-c[i]].append(r[i])

    ans = maxl // 2
    for x in dic:
        dic[x].sort()
        ans += dic[x][-1] - dic[x][0]
            
    ANS.append(ans)

print ("\n".join(map(str,ANS)))