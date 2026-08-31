import sys,math
input = lambda: sys.stdin.readline().rstrip("\r\n")
m=998244353
def modExp(a,n,m=10**9+7):
    if n==0:
        return 1
    elif n==1:
        return a
    else:
        while n>=2:
            if n%2==0:
                n=n//2
                return modExp(((a%m)*(a%m))%m,n,m)
            else:
                n=(n-1)//2
                return ((a%m)*modExp(((a%m)*(a%m))%m,n,m)%m)%m
def nCr(n,r,m):
    return (fact[n]*modExp((fact[n-r]*fact[r])%m,m-2,m))%m
fact={0:1,1:1}
n,k=map(int,input().split())
a,d=[],[]
for i in range(n):
    fact[i+2]=(fact[i+1]*(i+2))%m
    x,y=map(int,input().split())
    a.append(x)
    d.append(y)
a.sort(reverse=True)
d.sort(reverse=True)
count=0
out=0
t=0
while len(d)!=0:
    if len(a)!=0:
        if a[-1]<=d[-1]:
            count+=1
            a.pop()
        else:
            d.pop()
            count-=1
            if count+1>=k:
                out+=nCr(count,k-1,m)
                out%=m
    else:
        d.pop()
        count-=1
        if count+1>=k:
            out+=nCr(count,k-1,m)
            out%=m
        else:
            break   
print(out) 