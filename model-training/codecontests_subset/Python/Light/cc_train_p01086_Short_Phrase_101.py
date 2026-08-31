# AOJ 1601: Short Phrase
# Python3 2018.7.13 bal4u

a = [5,7,5,7,7]

while True:
	n = int(input())
	if n == 0: break
	ans = 0
	w = [len(input()) for i in range(n)]
	for i in range(n):
		k = s = 0
		for j in range(i, n):
			s += w[j]
			if s == a[k]:
				s, k = 0, k+1
				if k == 5: ans = i+1; break
			elif s > a[k]: break
		if ans: break
	print(ans)

