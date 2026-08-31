for i in range(int(input())):
	numLen = int(input())
	nums = input()
	nums = list(map(int, nums.split()))
	numLen = len(nums) # more reliable than usr input
	if numLen < 3: # prevent hacking
		print(-1)
		continue
	answer = False
	for x in range(numLen):
		if x == numLen-1: break
		a = nums[x]
		b = nums[x+1]
		c = nums[numLen-x-1]
		if not a+b>c and a+c>b and b+c>a:
			print(" ".join(list(map(str, [x+1, x+2, numLen-x]))))
			answer = True
			break
	if not answer: print(-1)
	
