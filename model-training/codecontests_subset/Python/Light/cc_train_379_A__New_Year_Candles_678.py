a = input().split()
ans, w = 0,0

for i in range(int(a[0])):
	ans=ans+1
	w=w+1
	if w == int(a[1]):
		w = 1
		ans = ans +1

print(ans)