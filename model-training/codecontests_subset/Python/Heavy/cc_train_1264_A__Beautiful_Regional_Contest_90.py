from collections import Counter
if __name__ == '__main__':
	for _ in range (int(input())):
		n = int(input())
		l = list(map(int,input().split()))
		if n < 6:
			print(0,0,0)
			continue
		a = (n//2)-1
		while l[a] == l[(n//2)] and a >= 0:
			a-=1
		if a < 2:
			print(0,0,0)
			continue
		l = l[:a+1].copy()
		b = len(l)
		d = Counter(l)
		l = set(l)
		if len(d)<3:
			print(0,0,0)
			continue
		g,s = 0,0
		a = sorted(l)[-1]
		# print(l)
		if d[a]>(b//2):
			print(0,0,0)
			continue
		else:
			g = d[a]
			l.remove(a)
		# print(l)
		for i in sorted(l)[::-1]:
			# print('*',i)
			s+=d[i]
			if s > g:
				break
		if (b-s-g) <= g:
			print(0,0,0)
		else:
			print(g,s,(b-s-g)) 