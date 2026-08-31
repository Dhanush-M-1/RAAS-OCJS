i,n=map(int,input().split())
candlesLit = 0
while i > 0:
	i -= 1
	candlesLit += 1
	if candlesLit % n == 0:
		i += 1
print(candlesLit)

