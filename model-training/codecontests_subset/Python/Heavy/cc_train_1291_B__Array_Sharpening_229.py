t = int(input())
ans=[]
for i in range(t):
	n = int(input())
	a = list(map(int, input().split()))
	inc_state, dec_state = False, False
	min_inc, min_dec = 0, n-1
	for i in range(n):
		if (a[i] < i) and (inc_state == False):
			min_inc = i-1
			inc_state = True
		if (a[n-1-i] < i) and (dec_state == False): 
			min_dec = n-i
			dec_state = True

	if (inc_state == False):
		min_inc = n-1
	if (dec_state == False):
		min_dec = 0


	
	if (min_dec <= min_inc):
		ans.append('Yes')
	else:
		ans.append('No')
for i in ans:
	print(i)
	
