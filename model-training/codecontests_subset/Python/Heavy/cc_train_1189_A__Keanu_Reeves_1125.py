n=int(input())
s=str(input())
a=len([x for x,d in enumerate(s) if d=='1'])
b=len([x for x,d in enumerate(s) if d=='0'])
if(a!=b):
	print("1")
	print(s)
else:
	g=''
	j=0
	t=[]
	count=0
	while(j<n):
		if(s[j]=='0'):
			b=b-1
			g=g+s[j]
			if(b!=a):
				count=count+2
				t.append(g)
				g=''
				for i in range(j+1,n):
					g=g+s[i]
				t.append(g)
				break
		else:
			a=a-1
			g=g+s[j]
			if(a!=b):
				count=count+2
				t.append(g)
				g=''
				for i in range(j+1,n):
					g=g+s[i]
				t.append(g)
				break
		j=j+1
	print(count)
	print(*t,sep=" ")


