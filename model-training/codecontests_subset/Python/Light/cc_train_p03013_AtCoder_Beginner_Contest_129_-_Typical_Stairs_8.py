G, N = [int(_) for _ in input().split(" ")]
ret = ()
T = [-1]*(G+1)
T[0] = 1
T[1] = 1
for i in range(N):
  t = int(input())
  T[t] = 0

for i in range(2, G+1):
	if T[i] == -1:
		T[i] = (T[i-1] + T[i-2]) % 1000000007

print (T[G])
