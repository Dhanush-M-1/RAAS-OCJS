def get(a):
	return max([a.count(i) for i in set(a)])


n, k = map(int, input().split())
a = sorted(list(map(int, input().split())))
b = a.copy()

can = set()
can.add(0)
for i in range(n):
	while b[i] != 0:
		can.add(b[i])
		b[i] //= 2

can = list(can)
ans = []
for i in range(len(can)):
	b = a.copy()
	local_ans = 0
	count = 0
	for j in range(n):
		now_count = 0
		while b[j] > can[i]:
			b[j] //= 2
			now_count += 1
		if b[j] == can[i]:
			count += now_count
			local_ans += 1
		if local_ans >= k:
			break
	if local_ans >= k:
		ans.append(count)

# print(ans)
print(min(ans))
