l = list(map(int,input().split()))
h = 0
a,b = l[0],l[1]
while (a>0):
	a-=1
	h+=1
	#print ('h',h,'a',a)
	if (h%b==0):
		a+=1
print (h)
