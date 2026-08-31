import sys

n, k = sys.stdin.readline().strip().split(' ')
a = sys.stdin.readline().strip().split(' ')
a = list(map(int,a))
s=0
m=0
n = int(n)
k = int(k)
for i in range(n,0,-1):
	r = k%a[i-1]
	if r==0 and a[i-1]>m:
		m=a[i-1]
s=k/m
print(int(s))