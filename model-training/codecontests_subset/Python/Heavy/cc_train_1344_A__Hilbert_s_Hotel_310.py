
t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    for i in range(n):
        a[i]=a[i]%n
        if a[i]<0:
            a[i]+=n
    #print(a)
    temp=[-i for i in range(1,n+1)]
    temp=temp[::-1]
    temp+=[i for i in range(n)]
    val=[]
    for i in range(2*n):
        if a[i%n]+temp[i]>=0:
            val.append(a[i%n]+temp[i])
    cc=[0 for __ in range(n)]
    for x in val:
        if x<n:
            cc[x]+=1
    if cc==[1]*n:
        print("YES")
    else:
        print("NO")
        
