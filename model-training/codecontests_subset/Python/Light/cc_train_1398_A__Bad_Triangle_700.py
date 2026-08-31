t = int(input())
while t>0:
	n = int(input())
	a = input().split(" ")
	i, j, k = 0, 1, n-1
	if int(a[i])+int(a[j])<=int(a[k]) or int(a[j])+int(a[k])<=int(a[i]) or int(a[i])+int(a[k])<=int(a[j]):
		print(i+1, j+1, k+1)
	else:
		print(-1)
	t-=1