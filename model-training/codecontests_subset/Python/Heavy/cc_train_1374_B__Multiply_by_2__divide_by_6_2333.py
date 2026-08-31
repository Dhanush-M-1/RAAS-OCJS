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
if __name__ == '__main__':
	def check(n):
		ans=0
		while(n!=0):
			ans+=n%10
			n=n//10
		if(ans%9==0):
			return True
		else:
			return False
	t=int(input())
	for j in range(1,t+1):
		n=int(input())
		if(n==1):
			print(0)
		elif(n==3):
			print(2)
		elif(n==6):
			print(1)
		elif(check(n)):
			c=0
			while(n<=1000000000000000000000000000000000 and n!=1):
				if(n%6==0):
					c+=1
					n=n//6
				else:
					c+=1
					n=n*2
			if(n==1):
				print(c)
			else:
				print(-1)
		else:
			print(-1)