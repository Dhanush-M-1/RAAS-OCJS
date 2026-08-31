p = input()
n = int(input())
a = []
for i in range(n):
	a.append(input())

f1,f2 = 0,0

for i in a:
	if i==p or i[::-1]==p:
		print("YES")
		exit()
	elif i[0]==p[1]:
		f1 = 1
	elif i[1]==p[0]:
		f2 = 1
if f1==f2==1:
	print("YES")
else:
	print("NO")