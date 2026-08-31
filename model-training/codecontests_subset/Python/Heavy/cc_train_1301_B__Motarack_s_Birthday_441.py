from sys import stdin
input = stdin.readline
q = int(input())
for rwere in range(q):
	n = int(input())
	l = list(map(int,input().split()))
	parki = []
	pelne = []
	pier = -1
	ost = - 1
	for i in range(n):
		if l[i] != -1:
			if pier == -1:
				pier = l[i]
			ost = l[i]
	if pier == -1:
		print(0,69)
	else:
		l = [pier] + l + [ost]
		#print(l)########
		n += 2
		for i in range(n):
			if l[i] != -1:
				pelne.append([l[i],i])
		p = len(pelne)
		for i in range(p-1):
			if pelne[i+1][1] - pelne[i][1] > 1:
				ad = [pelne[i][0], pelne[i+1][0]]
				ad.sort()
				parki.append(ad)
		#print(parki)
		le = 0
		r = 10**9
		bescik = 0
		while abs(le-r) > 0:
			m = (le+r)//2
			mini = -1000000000000000
			maksi = 1000000000000000
			for para in parki:
				mini = max(para[1]-m, mini)
				maksi = min(para[0]+m, maksi)
			if maksi >= mini:
				r = m
			else:
				le = m + 1
			bescik = (mini+maksi)//2
			#print(le,r,bescik)
		m = (le+r)//2
		worst = 0
		for i in range(n-1):
			if l[i] != -1 and l[i+1] != -1:
				worst = max(worst,abs(l[i]-l[i+1]))
		print(max(worst,m), bescik)