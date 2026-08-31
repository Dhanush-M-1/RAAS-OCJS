a=[]
b=[]
text= input();
a.append(text.split()[0])
b.append(text.split()[1])
n = int(input())

for i in range(n):
	text = input()
	a.append(text.split()[0])
	b.append(text.split()[1])

for i in range(n+1):
	print(a[i],'',b[i])
	if i == n : continue
	if a[i] == a[i+1]:
		a[i+1]= b[i+1]
		b[i+1]=b[i]
	if b[i] == a[i+1]:
		a[i+1]= a[i]



	

