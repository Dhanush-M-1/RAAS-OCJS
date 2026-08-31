a = input()
found , f1, f2 = False, 0, 0
for _ in range(int(input())):
	b = input()
	if a == b : found = True
	if a[0] == b[1] : f1 = 1
	if a[1] == b[0] : f2 = 1
if found or (f1 and f2) : print ("YES")
else : print ("NO")