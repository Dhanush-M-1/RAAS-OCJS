import sys 
# try:
#     sys.stdin = open('input.txt', 'r') 
#     sys.stdout = open('output.txt', 'w')
# except:
#     pass
d={}
cnt = 0
for i in 'abcdefghijklmnopqrstuvwxyz':
	d[i] = cnt
	cnt+=1
for _ in range(int(sys.stdin.readline())):
	n,m = map(int,sys.stdin.readline().split())
	s = sys.stdin.readline()
	p = list(map(int,sys.stdin.readline().split()))
	p.sort()
	p.append(n)
	ans = [0]*26
	crrans = [0]*26
	curr = 0
	for i in range(m+1):
		val = p[i]
		for j in range(curr,val):
			crrans[d[s[j]]] += 1
		for j in range(26):
			ans[j] += crrans[j]
		curr = val
	for i in range(26):
		sys.stdout.write(str(ans[i]))
		sys.stdout.write(" ")
	sys.stdout.write('\n')
