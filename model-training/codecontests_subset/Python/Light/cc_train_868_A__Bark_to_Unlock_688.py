a=str(input())
n=int(input())
f=0
g=0
for i in range(n):
	s=str(input())
	if s==a:
		print("YES")
		exit()
	elif s[0]==a[1] and s[1]==a[0]:
		print("YES")
		exit()
	elif s[1]==a[0]:
		if f==1:
			print("YES")
			exit()
		else:
			g=1	
	elif s[0]==a[1]:
		if g==1:
			print("YES")
			exit()
		else:
			f=1
print("NO")								
