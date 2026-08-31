x,y = list(map(str,input().split()))
print(x,y)
n = int(input())
for i in range(n):
	a,b = list(map(str,input().split()))
	if a==x:
		x = b
		print(x,y)
	elif a==y:
		y = b
		print(x,y)
	elif b==x:
		x=a
		print(x,y)
	elif b==y:
		y = a
		print(x,y)