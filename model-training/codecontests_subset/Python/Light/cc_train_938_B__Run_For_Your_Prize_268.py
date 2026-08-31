n=int(input())
x=input().split(' ')
ans=-1
for i in x:
	ans=max(ans,min(int(i)-1,1000000-int(i)))
print(ans)