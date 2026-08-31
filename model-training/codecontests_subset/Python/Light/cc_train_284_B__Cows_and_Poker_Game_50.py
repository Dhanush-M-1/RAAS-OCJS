n=int(input())
m=input()
if m.count('I')==1:
	print(1)
elif m.count('I')>1:
	print(0)
else:
	print(m.count('A'))
	