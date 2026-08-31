n,k=[int(x) for x in input().split()]
a = [int(x) for x in input().split()]
ans=0;
for i in range(len(a)):
    if (k%a[i]==0):
        ans=max(ans,a[i])

print (int(k/ans))
        
