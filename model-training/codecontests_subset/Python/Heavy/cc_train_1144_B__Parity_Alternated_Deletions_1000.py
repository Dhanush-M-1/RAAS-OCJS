n=int(input())
l=list(map(int,input().split()))

o=[]
e=[]

for x in l:
	if x%2==0:
		e.append(x)

	else:
		o.append(x)

e.sort()
o.sort()

if len(e)==0:
	del o[-1]
	k=o

elif len(o)==0:
	del e[-1]
	k=e

elif len(o)==len(e):
	if sum(e)>=sum(o):
		for x in range(len(e)):	
			del e[-1]
			del o[-1]
		k=e+o

	if sum(o)>sum(e):
		for x in range(len(e)):	
			del e[-1]
			del o[-1]
		k=e+o

elif len(e)>len(o):
	for x in range(len(o)+1):
		del e[-1]	
	k=e		

else:
	for x in range(len(e)+1):
		del o[-1]					
	k=o

print(sum(k))
