def f(ch):
	return ord(ch) - ord('0')

n = int(input())
v = list(map(int, input().split()))

fr = [0] * 20

for x in v:
	fr[len(str(x))] += 1

for i in range(1, 20):
	fr[i] += fr[i - 1]

ans = 0

pre = [[-1] * 20 for _ in range(20)]
for x in v:
	strx = str(x)[::-1]
	for i in range(len(strx)):
		ans += (10 ** (2 * i + 1)) * (n - fr[i]) * f(strx[i])

		dig = f(strx[i])
		if pre[i][dig] == -1:
			pre[i][dig] = 0
			for j in range(1, i + 1):
				pre[i][dig] += (10 ** (i + j)) * (fr[j] - fr[j - 1]) * f(strx[i])

		ans += pre[i][dig]
		#print('x', x, i, ans)

pre = [[-1] * 20 for _ in range(20)]
for y in v:
	stry = str(y)[::-1]
	for i in range(len(stry)):
		ans += (10 ** (2 * i)) * (n - (fr[i - 1] if i > 0 else 0)) * f(stry[i])

		dig = f(stry[i])
		if pre[i][dig] == -1:
			pre[i][dig] = 0
			for j in range(1, i):
				pre[i][dig] += (10 ** (i + j)) * (fr[j] - fr[j - 1]) * f(stry[i])

		ans += pre[i][dig]
		#print('y', y, i, ans)

print(ans % 998244353)
