n = int(input())

a = list(map(int, input().split()))

odd = 0
even = 0

for i in range(len(a)):
	if(a[i] % 2 == 0):
		even += 1
	else:
		odd += 1

if(even == odd):
	print(0)
elif(abs(odd - even) == 1):
	print(0)	
else:
	ans = 0
	a.sort()
	if(len(a) == 2):
		print(a[0])
	else:
		if(odd > even):
			diff = odd - even - 1
			i = 0
			while(diff > 0):
				if(a[i]%2 != 0):
					ans += a[i]
					diff -= 1
				i += 1
		else:
			diff = even - odd - 1
			i = 0
			while(diff > 0):
				if(a[i] % 2 == 0):
					ans += a[i]
					diff -= 1
				i += 1

		print(ans)
