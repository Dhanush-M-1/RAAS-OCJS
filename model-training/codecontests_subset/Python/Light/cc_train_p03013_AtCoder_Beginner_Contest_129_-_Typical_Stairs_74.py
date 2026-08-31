N, M = map(int, input().split())

st = [1] * (N+1)

for i in range(M):
    x = int(input())
    st[x] = 0


for i in range(2, N+1):
    if st[i]:
        st[i] = st[i-1] + st[i-2]

#print(st)
print(st[-1] % 1000000007)
