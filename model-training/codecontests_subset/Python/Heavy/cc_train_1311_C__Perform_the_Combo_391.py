'''Author- Akshit Monga'''
from sys import stdin, stdout
input = stdin.readline
t = int(input())
for _ in range(t):
    n,m=map(int,input().split())
    s=input().strip()
    vals=[int(x) for x in input().split()]
    ans = [0 for i in range(26)]
    pre=[[0 for i in range(n)] for j in range(26)]
    for i in range(n):
        for j in range(26):
            if i:
                pre[j][i]=pre[j][i-1]
            if ord(s[i])-97==j:
                pre[j][i]+=1
        ans[ord(s[i])-97]+=1
    d={}
    for i in vals:
        d[i]=d.get(i,0)+1
    for i in d:
        for j in range(26):
            ans[j]+=d[i]*pre[j][i-1]
    print(*ans)