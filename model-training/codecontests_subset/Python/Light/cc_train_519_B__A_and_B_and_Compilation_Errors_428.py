n = int(input())

a = list(input().split())
b = list(input().split())
c = list(input().split())

a.sort()
b.sort()
c.sort()

i = 0
while i < len(b) and a[i] == b[i]:
	i+=1
print(a[i])

i = 0
while i < len(c) and b[i] == c[i]:
	i+=1
print(b[i])
