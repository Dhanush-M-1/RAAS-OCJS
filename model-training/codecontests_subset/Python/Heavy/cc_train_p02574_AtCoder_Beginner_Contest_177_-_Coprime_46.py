N = int(input())
A = list(map(int, input().split()))

MAX = max(A)

# remap
AR = [0] * (MAX+1)
V = [False] * (MAX+1)
for i in range(N): AR[A[i]] += 1
pairwise, setwise = True, True

# sieve
for i in range(2, MAX+1):
    if V[i]: continue
    cnt, j = 0, i
    while j < MAX+1:
        cnt += AR[j]
        V[j] = True
        j += i
    if cnt > 1: pairwise = False
    if cnt == len(A): setwise = False

if pairwise:
    print('pairwise coprime')
elif setwise:
    print('setwise coprime')
else:
    print('not coprime')