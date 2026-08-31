import sys

def input():    return sys.stdin.readline().strip()
def iinput():   return int(input())
def rinput():   return map(int, sys.stdin.readline().strip().split()) 
def get_list(): return list(map(int, sys.stdin.readline().strip().split())) 

n=iinput()
a=get_list()
b=get_list()
c=get_list()

a.sort()
b.sort()
c.sort()

if(a[:n-1]==b):
	l=a[-1]
else:
	for i in range(n-1):
		if(a[i]!=b[i]):
			l=a[i]
			break

if(b[:n-2]==c):
	k=b[-1]
else:
	for i in range(n-2):
		if(b[i]!=c[i]):
			k=b[i]
			break

print(l)
print(k)