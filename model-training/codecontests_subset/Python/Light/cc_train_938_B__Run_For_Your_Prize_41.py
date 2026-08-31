n = int(input())
a = list(map(int, input().split()))

k = 1000000
l = 0
for i in a:
	if i <= 500000:
		if l < i:
			l = i
	if i > 500000:
		if k > i:
			k = i

ma = max(a)
if ma <= 500000:
	print(ma - 1)
else:
	print(max(l - 1, 1000000 - k))