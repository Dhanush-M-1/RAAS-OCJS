t=int(input())
for i in range(t):
	n=int(input())
	lista=list(map(int,input().split()))
	if(lista[0]+lista[1]>lista[-1]):
		print(-1)
	else:
		print(1,2,n)