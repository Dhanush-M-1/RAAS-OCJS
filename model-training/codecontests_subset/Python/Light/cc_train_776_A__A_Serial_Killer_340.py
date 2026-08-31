s=input().split()
print(*s)
for i in range(int(input())):
	x,y=input().split()
	s[s.index(x)]=y
	print(*s)