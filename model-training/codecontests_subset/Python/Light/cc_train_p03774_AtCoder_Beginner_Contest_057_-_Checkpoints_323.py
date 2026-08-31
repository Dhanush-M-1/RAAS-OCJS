n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in '1'*n]
b = [list(map(int, input().split())) for _ in '1'*m]
for i in a:
	d=[]
	for j in b:
		d.append(abs(i[0]-j[0])+abs(i[1]-j[1]))
	print(d.index(min(d))+1)