from sys import stdin,stdout
from collections import Counter
def ai(): return list(map(int, stdin.readline().split()))
def ei(): return map(int, stdin.readline().split())
def ip(): return  int(stdin.readline().strip())
def op(ans): return stdout.write(str(ans) + '\n')

n = ip()
s = [i for i in input()]
s2 = sorted(s)
#print(s);print(s2)
if s2 < s:
	c = 0
	idx = []
	for i in range(n):
		if s[i] != s2[i]:
			idx.append(i+1)
			for j in range(i+1,n):
				if s[j] != s2[j] and s[j] == s2[i]:
					idx.append(j+1)
					c += 1
					break
			if c>0: break
	if len(idx) ==2:
		print('YES')
		print(idx[0],idx[1])
	else:
		print('NO')
else:
	print('NO')
