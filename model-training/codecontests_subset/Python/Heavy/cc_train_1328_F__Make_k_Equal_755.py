import sys
input = sys.stdin.readline

n, k = list(map(int, input().split()))
A = list(map(int, input().split()))
A.sort()

ops = [0] * 200007

for i in range(n):
    alph = A[i]
    while alph > 0:
        ops[alph] += 1
        alph //= 2

    ops[0] += 1

ans = float('inf')
for i in range(200007):
    if ops[i] >= k:
        count = 0
        numOps = 0
        for j in range(n):
            if count == k:
                break
            alph = A[j]
            tmpOps = 0
            while alph > i:
                alph //= 2
                tmpOps += 1
            if alph == i:
                count += 1
                numOps += tmpOps

        ans = min(ans, numOps)

print(ans)
