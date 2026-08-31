n ,k = map(int, input().split(" "))
arr_both = []
arr_alice = []
arr_bob = []

for i in range(n):
	t1 ,t2, t3 = map(int, input().split(" "))
	
	if(t2==0 and t3==0):
		continue
	elif(t2==1 and t3==1):
		arr_both.append(t1)
	elif(t2==1):
		arr_alice.append(t1)
	else:
		arr_bob.append(t1)

i = 0
j = 0
arr_alice.sort()
arr_bob.sort()

while(i<len(arr_alice) and j<len(arr_bob)):
	arr_both.append(arr_alice[i] + arr_bob[j])
	i += 1
	j += 1


arr_both.sort()
if(len(arr_both)<k):
	print(-1)
else:
	print(sum(arr_both[0:k]))

