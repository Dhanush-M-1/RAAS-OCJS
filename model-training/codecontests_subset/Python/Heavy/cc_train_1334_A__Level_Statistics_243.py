import sys
input=sys.stdin.readline
t=int(input())
for r in range(t):
    n=int(input())
    p=[]
    c=[]
    for i in range(n):
        pi,ci=map(int,input().split())
        p.append(pi)
        c.append(ci)
    tempp=sorted(p)
    tempc=sorted(c)
    if p==tempp and c==tempc:
        flag=True
        flag2=True
        for i in range(n):
            if p[i]<c[i]:
                flag=False
        for i in range(n-1):
            if abs(p[i]-p[i+1])<abs(c[i]-c[i+1]):
                flag=False
        if flag==True and flag2==True:
            print("YES")
        else:
            print("NO")
    else:
        print("NO")