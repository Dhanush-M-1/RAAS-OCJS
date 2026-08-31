s = input().split()
n = int(s[len(s)-1])
size = (len(s)-1)//2
masP = [0]
masM = []
P, M = 1, 0
for i in range(1, len(s)-2, 2):
	if s[i]=='+':
		P += 1
		masP.append(i+1)
	else:
		M += 1
		masM.append(i+1)
sum1 = n+M*n
sum2 = n+M
if n+M > n*P or n+M*n < P:
	print ("Impossible")
else:
	print ("Possible")
	while M!=0:
		for u in range(1, n+1):
			if sum2+u-1 <= n*P and sum1+u-n >= P:
				s[masM.pop()] = u
				M = M-1
				sum2 = sum2+u-1
				sum1 = sum1+u-n
				break
	while P!=0:
		a = sum2//P
		s[masP.pop()] = a
		P = P-1
		sum2 = sum2-a
	print (' '.join(str(x) for x in s))