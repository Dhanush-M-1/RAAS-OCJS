n,k = map(int, input().split())

answ = n
while n >= k:
	tmp = n // k
	tmp2 = n % k
	answ += tmp
	n = tmp + tmp2
print(answ)
