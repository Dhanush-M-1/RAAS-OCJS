from collections import defaultdict as dd
t=int(input())
for _ in range(t):
    n,m=map(int,input().split())
    s=input()
    p=list(map(int,input().split()))
    d=dd(int)
    for i in p:
        d[i]+=1
    a=[0 for x in range(26)]
    p=list(set(p))
    p.sort()
    arr=[0 for x in range(n)]
    m+=1
    ptr=0
    for i in range(n):
        arr[i]=m
        if m>1 and p[ptr]-1==i:
            m-=d[p[ptr]]
            ptr+=1
    for i in range(n):
        a[ord(s[i])-97]+=arr[i]
    print(" ".join(map(str,a)))