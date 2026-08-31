n=int(input())
x=["a"]
d="abcdefghij"
i=1
while i<n:
	y=[]
	for t in x:
		for s in d[:len(set(t))+1]:
			y.append(t+s)
	x=y
	i+=1
print("\n".join(x))