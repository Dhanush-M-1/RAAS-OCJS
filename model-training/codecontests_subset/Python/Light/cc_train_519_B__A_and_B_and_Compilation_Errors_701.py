a=int(input())
init=input().split()
fix1=input().split()
fix2=input().split()
init.sort(key=float)
fix1.sort(key=float)
fix2.sort(key=float)
i=0
while i<a-1:
	if init[i]!=fix1[i]:
		print(init[i])
		break
	else:
		i+=1
else:
	print(init[i])

j=0
while j<a-2:
	if fix1[j]!=fix2[j]:
		print(fix1[j])
		break
	else:
		j+=1
else:
	print(fix1[j])
