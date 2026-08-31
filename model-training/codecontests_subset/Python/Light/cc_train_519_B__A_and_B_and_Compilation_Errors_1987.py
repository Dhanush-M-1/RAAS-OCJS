n=int(input())
l1,l2,l3=list(map(int,input().split())),list(map(int,input().split())),list(map(int,input().split()))
l1.sort()
l2.sort()
l3.sort()
ans=0
for i in range(n-1):
    if(l1[i]!=l2[i]):
        ans=l1[i]
        break
if(ans==0): ans=l1[-1]
print(ans)

ans=0
for i in range(n-2):
    if(l2[i]!=l3[i]):
        ans=l2[i]
        break
if(ans==0): ans=l2[-1]
print(ans)