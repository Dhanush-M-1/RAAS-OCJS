n = (int)(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

a = sorted(a)
b = sorted(b)
c = sorted(c)
flag = False

for i in range(len(b)):
	if a[i] != b[i]:
		print (a[i])
		flag = True
		break
if not flag: print (a[len(a)-1])
flag = False
for i in range(len(c)):
	if c[i] != b[i]:
		print (b[i])
		flag = True
		break
if not flag: print (b[len(b)-1])
