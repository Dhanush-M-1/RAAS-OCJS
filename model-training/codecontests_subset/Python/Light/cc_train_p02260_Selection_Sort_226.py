cnt = 0
n = int(input())
a = list(map(int,input().split()))
for i in range(0,n):
	mini = i
	for j in range(i,n):
		if a[j]<a[mini]:
			mini = j
	a[i],a[mini] = a[mini],a[i]	
	if i!=mini:
		cnt += 1
print(" ".join(map(str,a)))
print(cnt)