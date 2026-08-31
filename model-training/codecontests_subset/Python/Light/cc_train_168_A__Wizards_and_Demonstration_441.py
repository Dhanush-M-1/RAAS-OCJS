from math import ceil
a,b,c = map(int,input().split())
t = c/100
# print(b/a)
# print(t-b/a)
if t <= b/a:
	print(0)
else:   
	l = float("{:.4f}".format(a*(t-(b/a))))
	print(ceil(l))
