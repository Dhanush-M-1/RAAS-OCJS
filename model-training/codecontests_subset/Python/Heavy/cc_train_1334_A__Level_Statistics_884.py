t=int(input())
for _ in range(t):
    n=int(input())
    la=[]
    lb=[]
    c=0
    for i in range(n):
        x,y=map(int, input().split())
        if y<=x:
            c=c+1
        la.append(x)
        lb.append(y)
    val=0
    for i in range(1,len(la)):
        if la[i]-lb[i]<la[i-1]-lb[i-1]:
            val=1
            break
        if la[i]<la[i-1]:
            val=1
            break
    for i in range(1,len(lb)):
        if lb[i]<lb[i-1]:
            val=1
            break
    if c==n and val==0:
        print("YES")
    else:
        print("NO")