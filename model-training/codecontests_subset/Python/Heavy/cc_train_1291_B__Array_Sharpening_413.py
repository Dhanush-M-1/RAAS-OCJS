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

def js(arr,x):
	l=0
	r=len(arr)-1
	ans=-1
	while(l<=r):
		m=(l+r)//2
		if(arr[m]<=x):
			ans=m
			l=m+1
		else:
			r=m-1
	return ans

def jg(arr,x):
	l=0
	r=len(arr)-1
	ans=-1
	while(l<=r):
		m=(l+r)//2
		if(arr[m]>=x):
			ans=m
			r=m-1
		else:
			l=m+1
	return ans
from math import *


# p=[]
# for i in range(2,1000001):
# 	b=0
# 	for j in range(2,int(i**0.5)+1):
# 		if(i%j==0):
# 			b=1
# 			break
# 	if(b==0):
# 		p.append(i)

# def isprime(n):
# 	return binarySearch(p,n)!=-1
	
# def factors(n):
# 	f=[]
# 	for i in range(2,int(n**0.5)+1):
# 		if(n%i==0):
# 			if(n%(n//i)==0):
# 				if(isprime(n//i)):
# 					f.append(n//i)
# 			if(isprime(i)):
# 				f.append(i)
# 	f.sort()
# 	return f[-1]

# n = int(input())

for __ in range(int(input())):
	n=int(input())
	ar=list(map(int,input().split()))
	s=-1
	c=0
	ans="Yes"
	for i in range(n):
		if(ar[i]>=i and ar[i]>=(n-1-i)):
			s=0
			c+=1
		elif(ar[i]>=i):
			s=-1
			c+=1
		elif(ar[i]>=(n-1-i)):
			if(s==-1):
				ans="No"
				s=1
				break
			c+=1
	if(c<n):
		print("No")
	else:
		print(ans)