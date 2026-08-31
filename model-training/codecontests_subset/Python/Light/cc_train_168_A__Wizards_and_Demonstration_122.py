l=input()
l=l.split()
n=int(l[0])
x=int(l[1])
y=int(l[2])
s=0
while (x/n)*100<y:
	s+=1
	x+=1
print(s)