n = input()
n = n.split()
m = int(n[1])
n = int(n[0])
c=0
while n>0:
	c+=1
	n-=1
	if(c%m==0):
		n+=1
print(c)