from sys import stdin,stdout
input = stdin.readline
from collections import deque as dq
mp = lambda : map(int,input().split())
it = lambda: int(input())
a,b = mp()
comman =[]
alice =[]
bob =[]
for books in range(a):
	t,x,y = mp()
	if x==y==1:
		comman.append(t)
	elif x&1:
		alice.append(t)
	elif y&1 :
		bob.append(t)
comman = dq(sorted(comman))
alice = dq(sorted(alice))
bob = dq(sorted(bob))
time =0
while b :
	if len(alice) and len(bob) and  len(comman):
		if alice[0] + bob[0] <=comman[0]:
			time+=(alice[0]+bob[0])
			alice.popleft()
			bob.popleft()
		else:
			time+=comman[0]
			comman.popleft()
	else:
		if len(comman)==0:
			if len(alice)>=b and len(bob)>=b:
				for ele in range(b):
					time+=(alice[ele] + bob[ele])
			else:
				time =-1
		else:
			if len(comman)>=b:
				for ele in range(b):
					time+=comman[ele]
			else:
				time =-1
		break
	b-=1
print(time)