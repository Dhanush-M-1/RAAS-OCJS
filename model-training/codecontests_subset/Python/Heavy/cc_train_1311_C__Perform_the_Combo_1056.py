from math import *
# from sys import stdin,stdout

def binarySearch(arr,x,i):
	l=i
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

def ceil(a,b):
	if a%b == 0:
		return int(a/b)
	else:
		return (a//b + 1)


for __ in range(int(input())):
	n,m=map(int,input().split())
	s=input()
	ar=list(map(int,input().split()))
	d=[]
	for i in range(n):
		d.append([0]*26)
	for i in range(n):
		if(i==0):
			d[i][ord(s[i])-97]=1
		else:
			for j in range(26):
				d[i][j]=d[i-1][j]
			d[i][ord(s[i])-97]+=1

	ans=[0]*26
	for i in range(m):
		for j in range(26):
			ans[j]+=d[ar[i]-1][j]

	for i in range(n):
		ans[ord(s[i])-97]+=1
	print(*ans)
	