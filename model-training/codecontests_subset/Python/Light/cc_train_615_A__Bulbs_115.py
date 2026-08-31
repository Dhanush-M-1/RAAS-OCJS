switch, bulbs=map(int, input().split()) 
on=[]

for _ in range(switch):
	l=list(map(int, input().split()[1:]))
	on+=l
on=list(set(on))


if len(on)!=bulbs:
	print("NO")
else:
	print("YES")
	