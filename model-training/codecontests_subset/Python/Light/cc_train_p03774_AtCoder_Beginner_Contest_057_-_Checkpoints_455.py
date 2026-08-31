n,m = map(int,input().split())
student = [tuple(map(int,input().split())) for i in range(n)]
check = [tuple(map(int,input().split())) for i in range(m)]
for a,b in student:
	d = [abs(a-c)+abs(b-d) for c,d in check]
	print(d.index(min(d))+1)
