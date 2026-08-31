n=int(input())
a=list(map(int,input().split()))
e=[]
o=[]
for i in range(n):
	if not(a[i]&1):
		e.append(a[i])
	else:
		o.append(a[i])
e.sort(reverse=True)
o.sort(reverse=True)
ans=0
if len(o)>len(e):
	for i in range(len(e)):
		o[i]=0
	for i in range(len(e)):
		e[i]=0
	for i in range(len(o)):
		if o[i]!=0:
			o[i]=0
			break
	print(sum(o)+sum(e))

elif len(e)>len(o):
	for i in range(len(o)):
		e[i]=0
	for i in range(len(o)):
		o[i]=0
	for i in range(len(e)):
		if e[i]!=0:
			e[i]=0
			break
	print(sum(o)+sum(e))

else:
	print("0")
