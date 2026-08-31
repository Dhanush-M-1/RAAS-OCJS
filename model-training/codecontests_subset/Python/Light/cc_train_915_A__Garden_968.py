n,k=[int(i)for i in input().split()]
a=[int(i) for i in input().split()]


ans=9999999999
for num in a:
	if k%num==0:
		ans=min(ans,k/num)
print(int(ans))
