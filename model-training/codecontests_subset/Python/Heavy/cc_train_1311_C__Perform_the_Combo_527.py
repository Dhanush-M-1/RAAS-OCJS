from collections import Counter
t=int(input())
for _ in range(t):
    n, m = map(int, input().split())
    s=input()
    l=[]
    p=[int(x)-1 for x in input().split()]
    d={x: 0 for x in 'abcdefghijklmnopqrstuvwxyz'}
    c=[0 for i in range(n)]
    for i in range(m):
        c[p[i]]+=1
    for i in range(n-1, 0, -1):
        c[i-1]+=c[i]
    for i in range(n):
        d[s[i]]+=c[i]+1
    for x in 'abcdefghijklmnopqrstuvwxyz':
        if x in d:
            print(d[x], end=' ')
        else:
            print(0, end=' ')
    print()
    
