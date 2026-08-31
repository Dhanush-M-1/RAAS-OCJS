n,k = list(map(int, input().strip().split()))
alice = []
bob = []
both = []
for _ in range(n):
	t,a,b = list(map(int, input().strip().split()))
	if (a==1 and b==1):
		both.append(t)
	elif (a==1):
		alice.append(t)
	elif (b==1):
		bob.append(t)
alice.sort()
bob.sort()
both.sort()
done = 0
i=0
j=0
time = 0
i_max = min(len(alice),len(bob))
j_max = len(both)
while ((i<i_max or j<j_max) and done<k):
	if (i<i_max and j<j_max):
		done += 1
		if (alice[i] + bob[i] < both[j]):
			time += (alice[i] + bob[i])
			i+=1
		else:
			time += both[j]
			j+=1
	elif (i<i_max):
		done += 1
		time += (alice[i] + bob[i])
		i += 1
	else:
		done += 1
		time += both[j]
		j+=1
if (done < k):
	print(-1)
else:
	print(time)