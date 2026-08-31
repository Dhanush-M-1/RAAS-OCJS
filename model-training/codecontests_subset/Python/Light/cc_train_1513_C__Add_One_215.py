import sys

def inp():
	return sys.stdin.readline().rstrip()


p=1_000_000_007
 
t = int(inp())
 
rec = [1]*200_010
for i in range(10):
	rec[i] = 1
for i in range(10,200_010):
	rec[i] = (rec[i-9] + rec[i-10])%p
 
for z in range(t):
	n,m = inp().split()
	m = int(m)
	res = 0
	for c in n:
		res = (res+rec[m+int(c)])%p
	print(res)
