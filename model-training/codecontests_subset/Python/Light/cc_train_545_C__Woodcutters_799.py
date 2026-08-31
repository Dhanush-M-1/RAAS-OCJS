n=int(input())
l=[]
for _ in range(n):
	l.append(list(map(int, input().split())))
def wood(l):
	n=len(l)
	a=float('-inf')
	s=0
	for i in range(n-1):
		j=l[i]
		if j[0]-j[1]>a:
			s+=1
			a=j[0]
		elif j[0]+j[1]<l[i+1][0]:
			s+=1
			a=j[0]+j[1]
		else:
			a=j[0]
	s+=1
	return s
print(wood(l))

