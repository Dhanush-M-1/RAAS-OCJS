a,b=map(int,input().split())
l=list(map(int,input().split()))
l.sort()
low=[]
eq=[]
high=[]
flag=True
num=int((a-1)/2)
for i in l:
    if i < b:
        low.append(i)
    elif i> b:
        high.append(i)
    else:
        if flag:
            eq.append(i)
            flag=False
        else:
            high.append(i)


if len(low) == len(high):
    print(0)
elif len(low) > len(high):
    k=b
    t=len(low)-num
    r=0
    n=-1
    for _ in range(t):
        r+=k-low[n]
        n-=1
    print(r)
else:
    k=b
    t=len(high)-num
    r=0
    n=0
    for _ in range(t):
        r+=high[n]-k
        n+=1
    print(r)
