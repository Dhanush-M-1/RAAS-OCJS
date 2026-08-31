import math
N = int(input())
A = list(map(int, input().split()))

maxA = max(A) + 1

C = [0] * maxA

g = 0

for a in A:
    C[a] += 1
    g = math.gcd(g, a)

pairwise = True

is_prime = [True] * maxA

for i in range(2, maxA):
    if is_prime[i]:
        cnt = 0
        for j in range(i, maxA, i):
            cnt += C[j]
            is_prime[j] = False

        if cnt > 1:
            pairwise = False

if pairwise:
    print("pairwise coprime")
    exit()

if g == 1:
    print("setwise coprime")

else:
    print("not coprime")