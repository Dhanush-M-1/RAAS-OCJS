n=int(input())
xor1=0
xor2=0
xor3=0
for i in range(3):
	if i == 0:
		s=input().split(' ')
		for j in s:
			xor1=xor1^int(j)
	elif i==1:
		s=input().split(' ')
		for j in s:
			xor2=xor2^int(j)
	else:
		s=input().split(' ')
		for j in s:
			xor3=xor3^int(j)
print(xor1^xor2)
print(xor2^xor3)

