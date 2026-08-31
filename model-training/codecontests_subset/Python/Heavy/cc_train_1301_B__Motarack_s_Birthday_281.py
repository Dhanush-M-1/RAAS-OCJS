

def solv():
    x=int(input())
    s=list(map(int,input().split()))
    p=0
    mx=0
    mn=10**9

    for n in range(x):
        if s[n]!=-1:
            p=1
            if n>0 and s[n-1]==-1:
                mx=max(mx,s[n])
                mn=min(mn,s[n])
            try:
                if s[n+1]==-1:
                    mx=max(mx,s[n])
                    mn=min(mn,s[n])

            except IndexError:
                pass
    if p==0:
        print(0,69)
        return
    res=(mx+mn)//2

    ans=0
    for n in range(x):
        if s[n]==-1:s[n]=res
    for n in range(x):
        if n>0:
            ans=ans=max(ans,abs(s[n]-s[n-1]))
        if n<x-1:
            ans=ans=max(ans,abs(s[n]-s[n+1]))
    print(ans,res)

for _ in range(int(input())):solv()