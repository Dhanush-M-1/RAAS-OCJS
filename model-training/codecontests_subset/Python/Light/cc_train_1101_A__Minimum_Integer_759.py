a = int(input())
for i in range(a):
	l, r, d = map(int,input().split())
	if l > d:
		print(d)
	else:
		print(d * ((r // d)+ 1))
