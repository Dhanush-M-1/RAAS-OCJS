s=input()
a1=s[0]
b1=s[1]
check=0
x=[]
y=[]
n=int(input())
for i in range(0,n):
	s1=input()
	if(((s==s1) or (s==s1[::-1])) and (check==0)):
		#print("ok")
		print("YES")
		check=1
	else:
		x.append(s1[0])
		y.append(s1[1])


if(check==0):
	#print("ok")
	if( a1 in y and b1 in x):
		print("YES")
	else:
		print("NO")
		