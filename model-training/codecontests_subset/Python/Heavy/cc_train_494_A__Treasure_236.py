'''import sys
st = input()
a = 0
b = 0
last = 0
v = []
for s in st:
	if s == "(":
		a += 1
	elif s == ")":
		a -= 1
	elif s == "#":
		a -= 1
		v.append(1)
	if a < 0:
		print(-1)
		sys.exit()

v[-1] += a
i=0
a = 0
for s in st:
	if s == "(":
		a += 1
	elif s == ")":
		a -= 1
	elif s == "#":
		a -= v[i]
		i += 1
	if a < 0:
		print(-1)
		sys.exit()
if a != 0:
	print(-1)
else:
	for vs in v:
		print(vs)'''


import sys
a=0
s=input()
l=[]
for i in s:
	if(i=='('):
		a=a+1
	elif(i==')'):
		a=a-1
	else:
		a=a-1
		l.append(1)
	if(a<0):
		print(-1)
		sys.exit()
l[-1]+=a
a=0
k=0
for j in s:
	if(j=='('):
		a=a+1
	elif(j==')'):
		a=a-1
	else:
		a=a-l[k]
		k=k+1
	if(a<0):
		print(-1)
		sys.exit()

if(a!=0):
	print(-1)
else:
	for j in l:
		print(j)