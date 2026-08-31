n = int(input())
a = list(input())

Is = 0
for i in range(len(a)):
	if a[i]== "I":
		Is+=1
if Is >= 2:
	print(0)
elif Is == 1:
	print(1)
else:
	count= 0 
	for i in range(len(a)):
		if a[i]=="A":
			count+=1
	print(count)