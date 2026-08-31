(n,k) = tuple(map(int, input().split()))
y = list(map(int, input().split()))
y.sort()
y.sort(reverse=True)
for i in y:
	if k%i==0:
		#print (i)
		print (int(k/i))
		break
	else:
		pass