n=int(input())
s=input()
add1=0
for i in s:
	if int(i)==8:
		add1+=1
		
print(min(add1,n//11))

