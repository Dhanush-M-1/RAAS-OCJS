s = input()

n = int(input())

print(s)

s = s.split()

for _ in range(n):
	a = input().split()

	s.remove(a[0])
	s.append(a[1])

	print(*s)
