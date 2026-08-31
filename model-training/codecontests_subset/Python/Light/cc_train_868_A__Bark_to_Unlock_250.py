par = input()
n = int(input())
nach = []
kon = []
iskl = []
for i in range(n):
	bukva = input()
	buk = bukva[0]
	va = bukva[1]
	nach.append(buk)
	kon.append(va)
	iskl.append(bukva)
if (par[1] in nach and par[0] in kon) or par in iskl:
	print("YES")
else:
	print("NO")
