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
	n,k=map(int,input().split(" "))
	alice,bob,both=[],[],[]
	for i in range(n):
		t,a,b=map(int,input().split(" "))
		if(a==1 and b==1):
			both.append(t)
		elif(a==1):
			alice.append(t)
		elif(b==1):
			bob.append(t)
	bob.sort()
	alice.sort()
	both.sort()
	if(len(alice)==0 or len(bob)==0):
		if(len(both)<k):
			print(-1)
		else:
			print(sum(both[0:k]))
	else:
		i1=0
		i2=0
		i3=0
		c1=0
		c2=0
		ans=0
		while(i1<len(alice) and i2<len(bob) and i3<len(both) and c1<k and c2<k):
			if(both[i3]<=alice[i1]+bob[i2]):
				c1+=1
				c2+=1
				ans+=both[i3]
				i3+=1
			else:
				c1+=1
				c2+=1
				ans+=alice[i1]
				ans+=bob[i2]
				i1+=1
				i2+=1
		if(c1==k and c2==k):
			print(ans)
		else:
			if(i1==len(alice) or i2==len(bob)):
				while(i3<len(both) and c1<k and c2<k):
					ans+=both[i3]
					c1+=1
					c2+=1
					i3+=1
				if(c1!=k):
					print(-1)
				else:
					print(ans)
			else:
				while(i1<len(alice) and c1<k):
					ans+=alice[i1]
					i1+=1
					c1+=1
				while(i2<len(bob) and c2<k):
					ans+=bob[i2]
					i2+=1
					c2+=1
				if(c1!=k or c2!=k):
					print(-1)
				else:
					print(ans)