n=int(input())
a=input()
# print(n,m,k)
c=0
p=0

for i in a:
	# print(i)
	if i=='8':
		c=c+1

	# print(k,w,h)
# c+=int((m-p)/k)
print(min(c,n//11))