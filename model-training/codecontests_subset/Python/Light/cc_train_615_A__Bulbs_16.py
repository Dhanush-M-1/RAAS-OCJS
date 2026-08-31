n,m=map(int,input().split())

s=set()
for _ in range(n):
	s.update(map(int,input().split()[1:]))

print(("NO","YES")[len(s)==m])