for _ in range(int(input())):
	n=int(input())
	s=[int(i) for i in input().split()]
	a=s[0]+s[1]
	k=-1
	for j in range(2,n):
		if a<=s[j]:
			k=j+1
			break
	if k!=-1:
		print(1,2,k)
	else:
		print(-1)
	 	          	 				  	 	    		