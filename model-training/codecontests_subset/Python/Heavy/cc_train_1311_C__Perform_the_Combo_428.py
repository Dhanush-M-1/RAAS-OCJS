# cook your dish here
t = int(input())
q = 'abcdefghijklmnopqrstuvwxyz'
for _ in range(t):
    n,m = list(map(int,input().split()))
    s = input()
    p = list(map(int,input().split()))
    l = [0 for i in range(n)]
    for i in p:
        l[i-1]= l[i-1]+1
    for i in range(n-2,-1,-1):
        l[i] = l[i]+l[i+1]
    d={}
    for i in q:
        d[i] = 0
    for i in s:
        d[i] += 1
    for i in range(n):
        d[s[i]] = l[i]+d[s[i]]
    l = []
    for i in q:
        l.append(d[i])
    print(*l)
    
    
        
    