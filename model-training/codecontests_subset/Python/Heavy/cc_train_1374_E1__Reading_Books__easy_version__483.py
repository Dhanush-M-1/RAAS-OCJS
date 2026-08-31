from sys import stdin
input = lambda: stdin.readline().rstrip("\r\n")
from collections import defaultdict as vector
from collections import deque as que
inin = lambda: int(input())
inar = lambda: list(map(int,input().split()))
from heapq import heappush as hpush,heappop as hpop

bob=[]
alice=[]
both=[]

n,k=inar()
for i in range(n):
	t,a,b=inar()
	if a==1 and b==1:
		both.append(t)
	elif a==1:
		alice.append(t)
	elif b==1:
		bob.append(t)
	else:
		continue
both.sort(reverse=True)
alice.sort(reverse=True)
bob.sort(reverse=True)
def top(x):
	if x==[]:
		return float('inf')
	else:
		return x[-1]
t=0
donealice=0
donebob=0
while(donealice<k or donebob<k):
	if both==[] and alice==[] and bob==[]:
		t=-1
		break
	if top(both)<top(alice)+top(bob):
		donealice+=1
		donebob+=1
		t+=both.pop()
		#print('#1')
	else:
		if alice:
			t+=alice.pop()
			donealice+=1
		if bob:
			t+=bob.pop()
			donebob+=1
		#print('#2')
print(t)

	

