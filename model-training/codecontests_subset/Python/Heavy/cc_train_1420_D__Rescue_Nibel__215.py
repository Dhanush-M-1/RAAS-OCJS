from sys import stdin,stdout
n,k=list(map(int,stdin.readline().split()))
fact=[1];lim=n+5;M=998244353
def modexp(a,b,M):
    ans=1
    while b>0:
        if b&1:ans=(ans*a)%M
        b=b>>1
        a=(a*a)%M
    return ans
for i in range(1,lim+1):
    fact+=[(fact[-1]*i)%M]
def Invfact(num):
    return modexp(num,M-2,M)
def nCr(n1,r1):
    num=fact[n1]
    den=Invfact(fact[r1])
    result=(num*den)%M
    den=Invfact(fact[n1-r1])
    result=(result*den)%M
    return result
for _ in range(1):#int(stdin.readline())):
    # n=int(stdin.readline())
    # n,k=list(map(int,stdin.readline().split()))
    arr=[];ans=cnt=0;dep=[]
    for i in range(n):
        aa,dd=list(map(int,stdin.readline().split()))
        arr+=[aa]
        dep+=[dd]
    arr.sort()
    dep.sort()
    aa=dd=0
    while aa<n and dd<n:
        if arr[aa]<=dep[dd]:
            cnt+=1
            if cnt>=k:
                ans=(ans+nCr(cnt-1,k-1))%M
            aa+=1
        else:
            cnt-=1
            dd+=1
    # for pt,type in l:
    #     cnt+=type
    #     # print(pt,type,cnt)
    #     if type==1:
    #         if cnt>=k:
    #             ans=(ans+nCr(cnt-1,k-1))%M
    print(ans)