m = int(input())
# for i in range(m):
# 	s=input()
# 	a=[]
# 	c=0
# 	i=0
# 	while(i<len(s)):
# 		a.append(ord(s[i]))
# 		i+=1
# 	a.sort()
# 	i=0
# 	while(i<len(a)-1):
# 		if(a[i+1]-a[i]!=1):
# 			print("no")
# 			c=1
# 			break
# 		i+=1
# 	if(c==0):
# 		print("yes")
a=list(map(int,input().split()))
a.sort()
i=0
s=0
o=0
e=0
while(i<len(a)):
	if(a[i]%2!=0):
		o+=1
	else:
		e+=1
	i+=1
if(e==o or e-o==1 or o-e==1):
	print(0)
elif(o==0 or e==0):
	print(sum(a)-a[len(a)-1])
else:
	if(o>e):
		t=o-e-1
		i=1
		j=0
		while(i<=t and j<len(a)):
			if(a[j]%2!=0):
				s+=a[j]
				i+=1
			j+=1
		print(s)
	else:
		t=e-o-1
		i=1
		j=0
		while(i<=t and j<len(a)):
			if(a[j]%2==0):
				s+=a[j]
				i+=1
			j+=1
		print(s)
