f=0
n=int(input())
p1=1
p2=2
sp=3
for _ in range(n):
    w=int(input())
    if w==sp:
        f=-1
        break
    if w==1:
        p1=1
        if sp==3:
            p2=3
            sp=2
        else:
            sp=3
            p2=2
    if w==2:
        p1=2
        if sp==3:
            p2=3
            sp=1
        else:
            sp=3
            p2=1
    if w==3:
        p1=3
        if sp==2:
            p2=2
            sp=1
        else:
            sp=2
            p2=1
    if sp==p1 or sp==p2:
        f=-1
        break
if f==0:
    print("YES")
else:
    print("NO")

