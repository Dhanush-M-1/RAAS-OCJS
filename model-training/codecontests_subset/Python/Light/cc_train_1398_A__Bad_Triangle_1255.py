T = int(input())
for case in range(T):
	i = int(input())
	#s = input()
	#m,n = [int(x) for x in input().split()]
	ls = [int(x) for x in input().split()]
	if ls[0] + ls[1] <= ls[-1]:
		print(1,2,len(ls))
	else:
		print(-1)
	
	#print(r)
