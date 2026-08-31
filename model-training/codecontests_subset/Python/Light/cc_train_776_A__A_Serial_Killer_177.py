s = input().split()
n = int(input())
print(*s)
for i in range(n):
	k = input().split()
	s[s.index(k[0])]=k[1]
	print(*s)