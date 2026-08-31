n = input()
k1 = n.count('1')
k2 = n.count('2')
k3 = n.count('3')
l1 = l2 = l3 = 0
if(k1==0):
	k1 = 1
	l1 = 1
for i in range(k1-1):
	print("1+", end='')
if(k1 > 0 and l1 == 0 and ( k2 >0 or k3>0)):
	print("1+",end='')
else:
	if(k1>0 and l1 == 0):
		print("1")
if(k2 == 0):
	k2 = 1
	l2 = 1
for i in range(k2-1):
	print("2+", end='')
if(k2 >0 and l2 == 0 and k3>0):
	print("2+",end='')
else:
	if(k2>0 and l2 == 0):
		print("2")
if(k3 == 0):
	k3 = 1
	l3 = 1
for i in range(k3-1):
	print("3+", end='')
if(k3>0 and l3 == 0):
	print("3",end='')