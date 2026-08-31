M=10**9+7

n=int(input())


def fact(n):
    ans=1
    for i in range(1,n+1):
        ans=(ans*i)%M
    return ans

total=fact(n)

def performMod(x,n,m):
    if n==0: return 1%m
    u=performMod(x,n//2,m)
    u=(u*u)%m
    if n%2==1: u=(u*x)%m
    return u

#no cycle cnts
#cnt=0
#for i in range(n): #put largest number at i
#    cnt+=ncr(n-1,i) #choose i elements out of all elements minus largest number to put left to i

#IDENTITY: sum(ncr(n,i))==2**n
cnt=performMod(2,n-1,M)

ans=(total-cnt+M)%M
print(ans)