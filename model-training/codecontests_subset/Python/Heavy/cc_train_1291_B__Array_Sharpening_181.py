t = int(input())
for j in range(t):
	n = int(input())
	a = input().split(" ")
	start = []
	end = []	

	for i in range(len(a)):
		a[i] = int(a[i])
		if a[i] >= i:
			start.append(1)
		else:
			start.append(0)
		if (a[i] >= n-1-i):
			end.append(1)
		else:
			end.append(0)

	possible = False
	for i in range(len(a)-1):
		start[i+1] *= start[i]
		end[n-2-i] *= end[n-1-i]

	for i in range(len(a)):
		if((start[i]*end[i])==1):
			possible = True

	if(possible):
		print("YES")

	else:
		print("NO")




