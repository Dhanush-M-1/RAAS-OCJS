n, m = map(int, input().split())

i = 0

wear_out = 0

while n > 0:
	i += 1
	n -= 1
	wear_out += 1
	if wear_out == m:
		n+=1	
		wear_out = 0
		
print(i)
	
