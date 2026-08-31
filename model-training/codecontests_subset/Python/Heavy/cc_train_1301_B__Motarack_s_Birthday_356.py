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
# from math import *
def ceil(a,b):
	if a%b == 0:
		return int(a/b)
	else:
		return (a//b + 1)

def c(ar,n):
	m=0
	for i in range(len(ar)-1):
		if(ar[i]==-1 and ar[i+1]==-1):
			m=max(m,abs(n-n))
		elif(ar[i]==-1):
			m=max(m,abs(n-ar[i+1]))
		elif(ar[i+1]==-1):
			m=max(m,abs(ar[i]-n))
		else:
			m=max(m,abs(ar[i]-ar[i+1]))
	return m


for __ in range(int(input())):
	n=int(input())
	ar=list(map(int,input().split()))
	l=0
	r=1000000010
	ans=0
	while(l<=r):
		m=(l+r)//2
		# print(l,m,r,ans)
		if(c(ar,m)>c(ar,m-1) and m-1>=0):
			r=m-1
			ans=m-1
		elif(c(ar,m)==c(ar,m-1) and m-1>=0):
			ans=m
			break
		elif(c(ar,m)>c(ar,m+1)):
			l=m+1
			ans=m+1
		else:
			ans=m
			break
	print(c(ar,ans),ans)