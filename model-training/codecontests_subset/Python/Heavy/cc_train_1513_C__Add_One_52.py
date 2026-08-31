import sys
input = sys.stdin.readline

mod = 10**9+7
maxx = (2*10**5)+20
from collections import Counter

ans = [1]*maxx
for i in range(10, maxx):
	ans[i] = (ans[i-9]+ans[i-10])%mod

for nt in range(int(input())):
	n, m = map(int,input().split())
	fans = 0
	n = str(n)
	for digit in n:
		# d = {}
		# for i in range(10):
		# 	d[i] = 0
		# d[int(digit)] = 1
		# for j in range(m):
		# 	new_d = {}
		# 	new_d[1] = (d[0]+d[9])%mod
		# 	new_d[0] = d[9]%mod
		# 	for i in range(2, 10):
		# 		new_d[i] = d[i-1]%mod
		# 	d = new_d
		# s = 0
		# for i in d:
		# 	s += d[i]
		fans += ans[m+int(digit)]
		fans %= mod

	# print (len(ans))
	# print (Counter(ans))
	print (fans%mod)
