a=int(input())

for i in range(a):
	b,c,d=map(int,input().split())
	if d>=min(b,c):
		print(max(b,c)+(d-max(b,c)%d))
	else:
		print(d)
