n = int(input())
a = list(map(int, input().split()))
d = {"e":[0,[]],"o":[0,[]]}
for i in range(n):
	if a[i]%2 == 0:
		d['e'][0] += 1
		d['e'][1].append(a[i])
	else:
		d['o'][0] += 1
		d['o'][1].append(a[i])
if (d['e'][0] == d['o'][0]) or abs(d['e'][0]-d['o'][0]) == 1:
	print("0")
else:
	x = min(d['e'][0], d['o'][0]) + 1
	d['e'][1].sort(reverse = True)
	d['o'][1].sort(reverse = True)
	summ = 0
	if x<len(d['e'][1]):
		summ += sum(d['e'][1][x:])
	if x<len(d['o'][1]):
		summ += sum(d['o'][1][x:])
	print(summ)