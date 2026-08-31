#                                               |
#   _` |  __ \    _` |   __|   _ \   __ \    _` |   _` |
#  (   |  |   |  (   |  (     (   |  |   |  (   |  (   |
# \__,_| _|  _| \__,_| \___| \___/  _|  _| \__,_| \__,_|

import sys
import collections

def read_line():
	return sys.stdin.readline()[:-1]
 
def read_int():
	return int(sys.stdin.readline())
 
def read_int_line():
	return [int(v) for v in sys.stdin.readline().split()]

t = read_int()
for i in range(t):
	n,l,r = read_int_line()
	u = r-l+1
	lt = l
	k = n
	while lt>0 and k>0:
		k-=1
		lt -= 2*(k)
	lt += 2*(k)
	k = n-k
	
	j= max(k,1)
	s = 0
	for i in range(1,j):
		s += 2*(n-i)

	lt = l
	lt -= s
	lt += 1
	i = j + lt//2
	ans = []
	if l%2==0:
		ans.append(i)
		i+=1	
	while j<=n and len(ans)<=u:
		if j!=k:	
			i = j+1
		while i<=n and len(ans)<=u:
			ans.append(j)
			ans.append(i)
			i+=1
		j+=1
	ans.append(1)
	print(*ans[:u])