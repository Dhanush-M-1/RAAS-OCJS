t=int(input())
for _ in range(t):
    n=int(input())
    s=list(map(int,input().split()))
    d={}
    p={}
    for i in range(n):
        if s[i]>=i:
            d[i]=1
        else:
            break
    count=0
    for i in range(n-1,-1,-1):
        if s[i]>=count:
            p[i]=1
            count+=1
        else:
            break
    count=0
    for i in range(n):
        if d.get(i)!=None and p.get(i)!=None:
            count=1
            print("Yes")
            break
    if(count==0):
        print("No")