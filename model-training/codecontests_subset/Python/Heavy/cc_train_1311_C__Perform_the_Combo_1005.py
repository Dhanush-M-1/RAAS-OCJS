import sys 
import string
# try:
# 	sys.stdin = open('input.txt', 'r') 
# 	sys.stdout = open('output.txt', 'w')
# except:
# 	pass
input = sys.stdin.readline
for tt in range(int(input())):
	n,m = map(int,input().split())
	s = input()
	p = list(map(int,input().split()))
	p.sort()
	ans = [0]*n
	st = 0
	for i in range(m): #Iterating over p (size m)
		for j in range(st,p[i]):
			ans[j] += m-i
		st = p[i]
	d = {c:0 for c in string.ascii_lowercase}
	for i in range(n):
		d[s[i]] += ans[i]+1
	print(*d.values(),sep=" ")