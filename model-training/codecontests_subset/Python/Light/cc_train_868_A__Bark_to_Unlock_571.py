passwd,flag,L=input(),0,[]
for _ in range(int(input())):
	s=input()
	if s==passwd: flag=1
	L.append(s)
for x in L:
	for y in L:
		if x[1]+y[0]==passwd: flag=1
print("YES" if flag else "NO")
