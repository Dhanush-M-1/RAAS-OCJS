k, n = [int(i) for i in input().split()]


a = []
b = []
both = []
for _ in range(k):
	t,x,y = [int(i) for i in input().split()]

	if(x == 1 and y == 1):
		both.append(t)
	elif x == 1:
		a.append(t)
	elif y == 1:
		b.append(t)

a.sort()
b.sort()
both.sort()
# print(a,b,both)

if len(a) + len(both) < n or len(b) + len(both) < n:
	print(-1)
	quit()

bI = 0
aI = 0
bothI = 0
count = 0
t = 0
while count < n:
	count += 1
	if len(a) != aI and len(b) != bI and len(both) != bothI:
		if a[aI]+b[bI]<both[bothI]:
			t += a[aI]+b[bI]
			aI += 1
			bI += 1
		else:
			t += both[bothI]
			bothI += 1
	elif len(a) != aI and len(b) != bI: #both is empty
		t += a[aI]+b[bI]
		aI += 1
		bI += 1
	else:
		t += both[bothI]
		bothI += 1
print(t)




