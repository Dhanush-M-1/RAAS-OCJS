n = list(input().split(" "))
num = int(input())
first = f'{n[0]} {n[1]}'
anslist =[first]
for _ in range(num):
	newstring = list(input().split(" "))
	if(newstring[0] in n):
		if(newstring[0] == n[0]):
			n[0]=newstring[1]
		else:
			n[1]=newstring[1]
	anslist.append(f'{n[0]} {n[1]}')
	
for i in anslist:
	print(i)