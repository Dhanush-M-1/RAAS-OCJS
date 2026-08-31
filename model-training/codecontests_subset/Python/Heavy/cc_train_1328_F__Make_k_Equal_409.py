import sys
input = sys.stdin.readline

n, k = list(map(int, input().split()))
A = list(map(int, input().split()))
A.sort()

num = [0] * 200007
ops = [0] * 200007

ans = float('inf')
for i in range(n):
    alph = A[i]
    tempOps = 0
    while alph > 0:
        num[alph] += 1
        ops[alph] += tempOps

        if num[alph] == k:
            ans = min(ans, ops[alph])

        alph //= 2
        tempOps += 1

    num[0] += 1
    ops[0] += tempOps
    if num[0] == k:
        ans = min(ans, ops[0])

print(ans)

# ans = float('inf')
# for i in range(200007):
#     if ops[i] >= k:
#         count = 0
#         numOps = 0
#         for j in range(n):
#             if count == k:
#                 break
#             alph = A[j]
#             tmpOps = 0
#             while alph > i:
#                 alph //= 2
#                 tmpOps += 1
#             if alph == i:
#                 count += 1
#                 numOps += tmpOps

#         ans = min(ans, numOps)

# print(ans)
