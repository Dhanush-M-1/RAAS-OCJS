t = int(input())
for _ in range(t):
    n,m = map(int,input().split())
    s = input()
    a = list(map(int,input().split()))
    c = [0 for i in range(26)]
    p = []
    for i in range(len(s)):
        v = []
        for j in range(26):
            v.append(0)
        p.append(v)
    for i in range(len(s)):
        p[i][ord(s[i])-97]+=1
    for i in range(1,len(p)):
        for j in range(len(p[i])):
            p[i][j] = p[i-1][j]+p[i][j]
    l = []
    a+=[n]
    for i in range(len(a)):
        l.append(p[a[i]-1])
    o = [0 for i in range(26)]
    for i in range(len(l)):
        for j in range(len(l[i])):
            o[j]+=l[i][j]
    print(*o)
    