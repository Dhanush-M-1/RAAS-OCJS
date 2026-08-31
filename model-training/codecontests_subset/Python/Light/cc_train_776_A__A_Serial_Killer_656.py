a,b=input().split()
n=int(input())
print(a,b)
s=[a,b]
for i in range(n):
	x,y=input().split()
	s.remove(x)
	s.append(y)
	print(*s)