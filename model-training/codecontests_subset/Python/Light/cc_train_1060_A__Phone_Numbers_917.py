n = int(input())
l = input()
a = len(l)%11
p = len(l)-a
if n<11:
	print(0)
else:	
	for i in range(p):
		if l.count("8")>=p//11:
			print(p//11)
			break
		elif l.count("8")<p//11:
			print(l.count("8"))
			break	
		else:print(0)
		break	
