

a = set()

a |= set(input().split(' '))

n = int(input())

print(*a)
for _ in range(n):
	s, t = input().split(' ')
	a.remove(s)
	a.add(t)
	print(*a)