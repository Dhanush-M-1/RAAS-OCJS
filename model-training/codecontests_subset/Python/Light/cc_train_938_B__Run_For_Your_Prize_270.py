
#k=int(input())
#n,m=map(int,input().split())

#a=list(map(int,input().split()))

#b=list(map(int,input().split()))


n=int(input())
a=list(map(int,input().split()))

m=min(a[n-1]-1,10**6-a[0])
for i in range(n-1):
    m=min(m,max(a[i]-1,10**6-a[i+1]))

print(m)

