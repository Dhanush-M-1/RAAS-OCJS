def solve():
    x=int(input())
    s=list(map(int,input().split()))
    z=[]
    for n in range(x):
        if s[n]!=-1:
            if n>0 and n<x-1:
                if s[n-1]==-1 or s[n+1]==-1:
                    z.append(s[n])
            elif n==0:
                if s[1]==-1:
                    z.append(s[0])
            else:
                if s[-2]==-1:
                    z.append(s[-1])

    z.sort()
    if len(z)==0:
        print(0,0)
        return
    res=(z[0]+z[-1])//2
    ans=0
    for n in range(1,x):
        if s[n]==-1:
            s[n]=res
        if s[n-1]==-1:
            s[n-1]=res
        ans=max(ans,abs(s[n]-s[n-1]))
    print(ans,res)

for n in range(int(input())):
    solve()