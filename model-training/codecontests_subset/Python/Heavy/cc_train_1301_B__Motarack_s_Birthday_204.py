from math import ceil
t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    cnt=0
    mmax=0
    mmin=1e9
    diff1=-1
    for i in range(len(a)-1):
        if a[i]==-1 and a[i+1]!=-1:
            cnt+=1
            mmax=max(mmax,a[i+1])
            mmin=min(mmin,a[i+1])
        elif a[i]!=-1 and a[i+1]==-1:
            cnt+=1
            mmax=max(mmax,a[i])
            mmin=min(mmin,a[i])
        else:
            diff1=max(diff1,abs(a[i]-a[i+1]))
    if not cnt:
        print('0 0')
        continue
    k=(mmax+mmin)//2
    print(max(abs(mmax-k),abs(mmin-k),diff1),k)

