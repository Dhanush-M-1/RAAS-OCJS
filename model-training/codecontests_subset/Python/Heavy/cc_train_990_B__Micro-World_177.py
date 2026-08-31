def binarySearch(n,i,k,a):
    l=i+1
    u=n-1
    ans=0
    while l<=u:
        mid=int((l+u)/2)
        if a[mid]==a[i] : 
            l=mid+1
        elif a[mid]-a[i]<=k:
            ans=1
            break
        else:
            u=mid-1
    return ans


n,k=map(int,input().split())
a=list(map(int,input().split()))

a.sort()
#print(str(a))
visited=[]
for i in range(0,n):
    visited.append(0) 
i=0
j=1
ctr=0
for i in range (0,n):
    val=binarySearch(n,i,k,a)
    ctr+=val

# print(str(visited))

print(n-ctr)




