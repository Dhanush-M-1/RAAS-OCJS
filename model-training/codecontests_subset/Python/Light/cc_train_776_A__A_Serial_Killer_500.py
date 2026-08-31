
l = list(input().split())
print(*l , sep = ' ')
n = int(input())
for _ in range(n):
	
	li = list(input().split())
	
	ind = l.index(li[0])
	l[ind] = li[1]
	print(*l , sep = ' ')


