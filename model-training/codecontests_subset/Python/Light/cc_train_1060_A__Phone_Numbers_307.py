n=int(input())
z=str(input())
q=0
for i in z:
	if i=="8":
		q+=1
		
y=n//11
if q==0:
	print (0)
else:
	print (min(y,q))
	
