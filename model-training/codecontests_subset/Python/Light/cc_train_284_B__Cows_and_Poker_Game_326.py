n = int(input())
s = input()
A,I=0,0

for i in range(n):
	if s[i]=="A":
		A+=1
	elif s[i]=="I":
		I+=1

if I>1:
	print(0)
elif I:
	print(1)
else:
	print(A)