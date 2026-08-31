import sys

MOD = 998_244_353 	

# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')

input = sys.stdin.readline
n, k = map(int, input().split(' '))
fact = [None for i in range(n+1)]

def C(n, k):
	if (k > n or k < 0):
		return 0
	return (
		fact[n] * pow(fact[k] * fact[n-k], MOD-2, MOD)
	) % MOD

fact[0] = 1

for i in range(1, n+1):
	fact[i] = (fact[i-1] * i) % MOD


starts = []
ends = []
for i in range(n):
	l, r = map(int, input().split(' '))
	starts.append(l)
	ends.append(r)

starts.sort()
ends.sort()

i = 0
j = 0

ans = 0
on_lamps = 0

while i < n or j < n:
	if i != n and starts[i] <= ends[j]:
		on_lamps += 1
		i += 1
		ans += C(on_lamps - 1, k-1)
		ans %= MOD
	else:
		on_lamps -= 1
		j += 1


print(ans)
