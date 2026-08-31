x=[int(x) for x in input().split()]
list_a=[int(x) for x in input().split()]
n=x[0]
k=x[1]
z=[]
for i in list_a:
	if k%i==0 :
		s=k/i
		z.append(int(s))
print(min(z))

			