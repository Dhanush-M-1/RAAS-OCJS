n,k = map(int,input().split())
i = 0
t = n
r = 0
while n >= k:
	
	t = t + n//k
	n = n//k + n%k

# print(t)
print(t)

