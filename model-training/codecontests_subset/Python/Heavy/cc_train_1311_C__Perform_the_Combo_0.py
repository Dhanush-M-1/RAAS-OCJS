from sys import stdin
from bisect import bisect_left
from collections import Counter
for k in range(int(stdin.readline())):
    n,m=[int(x) for x in stdin.readline().split()]
    s=input()
    d=Counter(s)
    l=list(map(int,stdin.readline().split()))
    l.sort()
    ans=[0 for j in range(0,26)]
    for j in range(0,len(s)):
        n=len(l)-bisect_left(l,j+1)
        ans[ord(s[j])-97]+=(n)
    e=list(d.keys())
    try:
        for i in range(0,len(e)):
            ans[ord(e[i])-97]+=(d[e[i]])
    except(Exception):
        pass
    print(*ans)