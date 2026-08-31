s=list(map(int,input().split()))
a=s[0]
b=s[1]
count=0
#while a-b+1>=b:
while True:
	#a=a-b+1
	#print(a)
	if a>b:
		a=a-b+1
		count+=1
	if a==b:
		count+=1
		a=1
		break
	if a<b:

		break

		
#print(count)
print(a+count*(b))