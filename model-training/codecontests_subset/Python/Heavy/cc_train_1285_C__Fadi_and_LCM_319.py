def binarySearch(arr,x):
	l=0
	r=len(arr)-1 
	while l <= r: 
		mid = (l + r)//2; 
		if arr[mid] == x: 
			return mid 
		elif arr[mid] < x: 
			l = mid + 1
		else: 
			r = mid - 1
	return -1

x=int(input())
f=[]
for i in range(1,int(x**0.5)+1):
	if(x%i==0):
		if(x%(x//i)==0):
			f.append(x//i)
		f.append(i)
from math import *
ans=[]
for i in range(len(f)):
	t=x//f[i]
	if(gcd(f[i],t)==1):
		if(f[i]>t):
			ans.append([t,f[i]])
		else:
			ans.append([f[i],t])
index=0
# print(ans)
c=ans[0][1]
for i in range(len(ans)):
	if(ans[i][1]<c):
		index=i
		c=ans[i][1]
print(*ans[index])
