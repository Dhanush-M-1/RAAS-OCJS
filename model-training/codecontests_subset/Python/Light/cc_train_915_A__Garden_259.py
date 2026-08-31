n,m = [int(i) for i in input().split()]
l = [int(i) for i in input().split()]
k = m
for i in range(n):
	if m%l[i] == 0 :
		k = min(k,m//l[i])
print(k)
