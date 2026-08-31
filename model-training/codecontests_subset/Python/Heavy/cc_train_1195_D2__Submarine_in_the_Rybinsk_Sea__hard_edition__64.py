n = int(input())
a = input().split()
b = [[] for i in range(10)]
c = [[] for i in range(10)]
d = [0 for i in range(11)]
ans = 0
for i in a:
	b[len(i)-1].append(i)

for i in range(9,-1,-1):
	d[i] = d[i+1] + len(b[i])

# print(d)

for i in range(10):
	for j in b[i]:
		k = ''.join(map(''.join, zip(j, j)))
		c[i].append(k)

for i in range(10):
	for j in range(i,10):
		for k in b[j]:
			idx = -i-1
			l = int(''.join(map(''.join, zip(k[idx:], k[idx:]))))
			# print(i,j,k,idx,l)
			if i == j:
				ans = ans + d[i]*l
			else:
				ans = ans + len(b[i])*l
				# print(int(k[:idx])*(10**(-idx*2)))
				ans = ans + 2*len(b[i])*int(k[:idx])*(10**(-idx*2))


# print(c)
print(ans % 998244353)