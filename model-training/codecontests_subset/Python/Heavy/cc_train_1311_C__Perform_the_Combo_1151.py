# Work hard. Complain harder. Unknown
# by : Blue Edge - Create some chaos

for _ in range(int(input())):
    n,m=map(int,input().split())
    s=input()
    p=list(map(int,input().split()))
    p.append(n)
    d=[0]*26
    a=[]
    for x in range(97,97+26):
        t=[]
        t.append(int(ord(s[0])==x))
        for i in range(1,n):
            t.append(t[-1]+int(ord(s[i])==x))
        # print(t)
        a.append(t)

    # print(d)
    # print(a)
    for x in p:
        for y in range(26):
            d[y]+=a[y][x-1]

    print(*d)
