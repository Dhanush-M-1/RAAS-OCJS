pswd=input()
n=int(input())
l=[]
res='NO'
for i in (range(n)):
	s=input()
	l.append(s)
	if s==pswd:
		res='YES'
		break
	
#print(l)

if res=='NO':	
	for i in (range(n)):
		if l[i][1]==pswd[0]:
			ind=i
			for k in (range(n)):
				if  l[k][0]==pswd[1]:
					res='YES'
					break
		
print(res)	