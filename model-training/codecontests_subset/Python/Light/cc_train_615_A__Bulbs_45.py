#615A. Bulbs
#implementation, 800, http://codeforces.com/contest/615/problem/A
 
n, m = map(int, input().split())
 
b = set()
for i in range(n):
	b.update(input().split()[1:])
 
c = set(map(str, range(1, m + 1)))
if b == c :
	print('YES')
else:
	print('NO')