from math import *
from copy import *
from string import *				# alpha = ascii_lowercase
from random import *
from sys import stdin,stdout
from sys import maxsize
from operator import *				# d = sorted(d.items(), key=itemgetter(1))
from itertools import *
from collections import Counter		# d = dict(Counter(l))
import math
import math
import time
from queue import Queue
# PradeepGhosh_2017076

def seive(n):
	l=[True]
	l=l*(n+1)
	for i in range(2,int(sqrt(n))+1):
		if(l[i]==True):
			val=i*i
			while(val<len(l)):
				l[val]=False
				val+=i
	prime=[]
	for i in range(2,len(l)):
		if(l[i]==True):
			prime.append(i)
	return prime

def dp(l,i,n,val,ans):
	if(i>=n or val<0):
		return 1000000
	elif(val==0):
		return 0
	else:
		if(ans[i]==1000000):
			ans[i]=min(min(1+dp(l,i+1,n,val-l[i],ans),1+dp(l,i,n,val-l[i],ans)),dp(l,i+1,n,val,ans))
		return ans[i]
from queue import Queue
def factors(n):
	l=[]
	for i in range(1,int(sqrt(n))+1):
		if(n%i==0):
			if(n//i==i):
				l.append(i)
			else:
				l.append(i)
				l.append(n//i)
	return l
def check1(s,v,x):
	while(True):
		if(v not in s):
			return v
		else:
			v-=1
def check2(s,v,x):
	while(True):
		if(v not in s):
			return v
		else:
			v+=1

def up(n):
	j=n-1
	while(j>0):
		if(n%j==0):
			break
		j-=1
	return j		
def fac(n):
	c=1
	i=1
	while(i<=n):
		c*=i
		i+=1
	return c
def check_happy(n):
	ss=set()
	print(n)
	while(n!=1):
		val=n
		s=0
		print(val)
		while(val!=0):
			s+=(val%10)**2
			val=val//10
		print(val)
		print("hi")
		if(val in ss):
			return False
		else:
			n=val
			ss.add(n)
	return True
def update(a,b):
	c=1
	val=a
	while(a<b):
		print(c,a)
		c+=c
		a+=a
	print(1)
	while(a>b):
		print()
		a-=val
		c-=1
	return c
import random as rand
def gcd(a,b): 
    if a == 0: 
        return b 
    return gcd(b % a, a) 
# nakdna
from itertools import permutations
def insertion_sort(arr):
	for i in range(len(arr)):
		j=i
		while(j>0):
			if(arr[j]<arr[j-1]):
				temp=arr[j]
				arr[j]=arr[j-1]
				arr[j-1]=temp
			j-=1
	return arr
def quick_sort(arr,low,high):
	i=low
	j=high
	
	while(i<j):
		if(arr[i]>arr[low] and arr[j]<arr[low]):
			temp=arr[i]
			arr[i]=arr[j]
			arr[j]=arr[i]
			i+=1
			j-=1
		elif(arr[i]<=arr[low]):
			i+=1
		elif(arr[j]>=arr[low]):
			j-=1
	print(i,j)
	toto=arr[j]
	arr[j]=arr[low]
	arr[low]=toto
	return j
def dodo(arr,low,high):
	if(low<high):
		val=quick_sort(arr,low,high)
		dodo(arr,low,val-1)
		dodo(arr,val+1,high)
def dp(arr,c,n,k,z,ans):
	if(k==0):
		return ans
	else:
		if(c==0):
			return dp(arr,c+1,n,k-1,z,ans+arr[c+1])
		elif(c==n-1):
			if(z==0):
				return 0
			else:
				return dp(arr,c-1,n,k-1,z-1,ans+arr[c-1])
		else:
			if(z==0):
				return dp(arr,c+1,n,k-1,z,ans+arr[c+1])
			else:
				return max(dp(arr,c+1,n,k-1,z,ans+arr[c+1]),dp(arr,c-1,n,k-1,z-1,ans+arr[c-1]))
def check(arr,val):
	a=-1
	for i in range(len(arr)):
		if(arr[i][len(arr[i])-1]==val):
			a=i
			break
	return a

def reverse(s,i,ans):
	if(i>=len(s)):
		return ans
	else:
		return reverse(s,i+1,s[i]+ans)
def update(arr,i,j,n,m):
    if(i>=0 and i<n and j>=0 and j<m):
        if(arr[i][j]==1):
            arr[i][j]==2
            return [i,j]
    return [-1,-1]
if __name__ == '__main__':
	n=int(input())
	ans=1
	for i in range(1,n+1):
		ans=(ans*i)%1000000007
	print((ans-(2**(n-1))%1000000007)%1000000007)