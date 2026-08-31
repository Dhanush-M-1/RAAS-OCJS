n,m=map(int,input().split())
a=[0]*(m+1)
mod=1000000007
for i in range(m):
    a[i]=int(input())
s=[1,1]
j=0
for i in range(2,n+1):
    if i-1==a[j]:
        s[i-1]=0
        j+=1
    s.append(s[i-1]+s[i-2])

print(s[n]%mod)


