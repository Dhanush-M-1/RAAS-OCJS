for _ in range(int(input())):
    n=int(input());s=list(map(int,input().split()))
    c=x=1;l=[0]*n;k=[0]*n
    for i in range(n):
        k[i] = int(s[i]>=i)
        l[i]=int(s[i]>=n-i-1)
    p=q=r=w=-1
    for i in range(n):
        if k[i]==0 and p==-1:
            p=i
        if l[i]==0:
            q=i
        if l[i]==0 and r==-1:
            r=i
        if k[i]==0:
            w=i
    if (p==-1 or q==-1) or (l[max(0,p-1)]==1 and q<p-1) or (k[max(r-1,0)]==1 and w<r-1):
        print("Yes")
    else:
        print("No")