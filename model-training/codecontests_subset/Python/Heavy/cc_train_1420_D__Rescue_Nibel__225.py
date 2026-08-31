mod = 998244353
import sys
input = sys.stdin.readline

def calc(n,r):
	return (fact[n]*pow((fact[r]*fact[n-r])%mod,mod-2,mod))%mod


fact = [1,1]
for i in range(2,4*10**5):
	fact.append((fact[-1]*i)%mod)

n,k = map(int,input().split())
s,e = [],[]
ds,de = {},{}
for i in range(n):
	l,r = map(int,input().split())
	s.append(l)
	e.append(r)
	if l in ds:
		ds[l] += 1
	else:
		ds[l] = 1
	if r in de:
		de[r] += 1
	else:
		de[r] = 1

s.sort()
e.sort()
i, j = 0, 0
count = 0
ans = 0
# print (s)
# print (e)
while j<n:
	if i<n and s[i]<=e[j]:
		count += 1
		i += 1
		if count>=k:
			ans += calc(count-1,k-1)
			ans = ans%mod
	else:
		count -= 1
		j += 1
		
print (ans)



