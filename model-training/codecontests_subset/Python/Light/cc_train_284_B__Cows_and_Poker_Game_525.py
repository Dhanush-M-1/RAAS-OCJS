n=int(input())
s=input()
i=s.count("I")
a=s.count("A")
if i==1:
	print(1)
elif i>1:
	print(0)
else:
	print(s.count("A"))