n,k=map(int,input().split())
A=list(map(int,(input().split())))
ls1=[]
for x in A:
	if(k%x==0):
		ls1.append(k/x)
print(int(min(ls1)))
