for i in range(int(input())):
	n=int(input())
	l=list(map(int,input().split()))
	for i in range(2,len(l)):
		if l[0]+l[1]<=l[i]:
			print(1,2,i+1)
			break
	else:
		print(-1)