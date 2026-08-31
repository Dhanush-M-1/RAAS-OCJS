
t = int(input())

while t > 0:
	n = int(input())
	lis = [int(a) for a in input().split()]

	i = 0
	j = n-1
	istrue = True

	while(j >= 2) and istrue:
		while(i <= j-2) and istrue:
			if(lis[j] >= lis[i]+lis[i+1]):
				print(i+1, i+2, j+1)
				istrue = False
				break
			i += 1
		j -= 1

	if(istrue): print(-1)

	t -= 1
