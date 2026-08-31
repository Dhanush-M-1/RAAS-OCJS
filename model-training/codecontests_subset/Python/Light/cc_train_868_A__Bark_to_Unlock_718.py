right=input()
n=int(input())
p=[]
s=''
r=''
flag=0
for i in range(0,n):
	p.append(input())
for i in range(0,n):
	curr=p[i]
	for j in range(0,i):
		s=curr+p[j]
		#print(s)
		if(s.find(right)!=-1):
			flag=1
	for j in range(i,n):
		s=curr+p[j]
		#print(s)
		if(s.find(right)!=-1):
			flag=1
if(flag==1):
	print("YES")
else:
	print("NO")