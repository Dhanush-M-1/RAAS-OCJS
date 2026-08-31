n = int(input())
h = [0]*n
x = [0]*n
for i in range(n):
	x[i], h[i] = map(int, input().split()) 
ans = 0
last = x[0]
for i in range(n):
	if i == 0 or i == n-1:
		ans += 1
		last = x[i]
		continue
	if x[i] - h[i] > last:
		ans += 1
		last = x[i]
	elif x[i] + h[i] < x[i+1]:
		ans += 1
		last = x[i] + h[i]
	last = max(last, x[i])
print (ans)