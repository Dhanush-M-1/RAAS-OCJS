# import sys
# sys.stdin = open("test.in","r")
# sys.stdout = open("test.out.py","w")
a=input()
b,c=0,0
for i in range(int(input())):
	d=input()
	if d==a:
		print('YES')
		exit()
	if d[1]==a[0]:
		b=1
	if d[0]==a[1]:
		c=1	
if b and c:
	print('YES')
else:
	print('NO')			