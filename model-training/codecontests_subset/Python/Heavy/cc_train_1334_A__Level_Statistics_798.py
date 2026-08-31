# cook your dish here
t = int(input())
while(t):
    n = int(input())
    l = []
    p=0
    c=0
    c1=0
    for i in range(n):
        a,b = map(int, input().split())
        l.append([a,b])
    for i in range(n):
        if(l[i][0]<p):
            c1=1
            break
        if(l[i][1]<c):
            c1=1
            break
        if(abs(l[i][1]-c)>abs(l[i][0]-p)):
            c1=1
            break
        p = l[i][0]
        c = l[i][1]
    if(c1==0):
        print("YES")
    else:
        print("NO")
    t-=1