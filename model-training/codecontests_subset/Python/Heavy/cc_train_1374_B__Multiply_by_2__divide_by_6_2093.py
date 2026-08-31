import math
t=int(input())
for _ in range(t):
    n=int(input())
    if n==1:
        print(0)
        continue
    q=math.log2(n)
    if q==int(q):
        print(-1)
        continue
    if n%2!=0 and n%3!=0:
        print(-1)
        continue
    k=1
    c=0
    w=0
    while(k):
        if n%6==0:
            n=n//6
            c+=1
            w=0
        else:
            c+=1
            n=n*2
            w+=1
        q=math.log2(n)
        if n==1:
            a=2
            k=0
        elif q==int(q) or w>=2:
            k=0
            a=1
    if a==2:
        print(c)
    else:
        print(-1)