n = (int) (input())
l = input()
l = [int(list(l)[i]) for i in range(n)]

count=0
tel=0

for i in range(n):
	if (l[i]==8):
		count+=1
if(count==0):
	print(0)
else:
	for i in range(count):
		if(i<(n-i)//10):
			tel+=1
	print(min(tel,(n-tel)//10))