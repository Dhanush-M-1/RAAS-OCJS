l=list(map(str,input().split()))
print(*l)
n=int(input())
for i in range(n):
	a,b=map(str,input().split())
	# print(*l)
	l.remove(a)
	l.append(b)
	print(*l)