from collections import defaultdict
n = int(input())
first = list(map(int, input().split()))
second = list(map(int, input().split()))
third = list(map(int, input().split()))

f = defaultdict(int)
s = defaultdict(int)
t = defaultdict(int)

for ele in first:
	f[ele] += 1
for ele in second:
	s[ele] += 1
for ele in third:
	t[ele] += 1

a = b = 0
for e,v in f.items():
	if s[e] != v:
		a = e
		break
for e,v in s.items():
	if t[e] != v:
		b = e
		break

print(a)
print(b)
