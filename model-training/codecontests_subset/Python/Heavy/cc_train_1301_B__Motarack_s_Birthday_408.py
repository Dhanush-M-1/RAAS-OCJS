# n = int(input())
# A, B, C = [], [], []
# for i in range(n):
#     A.append(input())
#     B.append(input())
#     C.append(input())
# ans = ['NO'] * n
# for i in range(len(A)):
#     c = 0
#     for j in range(len(A[i])):
#         if A[i][j] == C[i][j] or B[i][j] == C[i][j]:
#             c += 1
#     if c == len(A[i]):
#         ans[i] = 'YES'
#
# for a in ans:
#     print(a)

t = int(input())
ans = []
for i in range(t):
    n = int(input())
    a = [int(p) for p in input().split(' ')]
    m = 0
    s = set()
    for j in range(0, n):
        if a[j] == -1:
            if j > 0 and a[j - 1] != -1:
                s.add(a[j - 1])
            if j < n - 1 and a[j + 1] != -1:
                s.add(a[j + 1])
    s = list(s)
    s.sort()
    k = 0
    if s:
        k = (s[0] + s[-1]) // 2
    m = 0
    if a[0] == -1:
        a[0] = k
    for j in range(1, n):
        if a[j] == -1:
            a[j] = k
        m = max(m, abs(a[j] - a[j - 1]))
    ans.append([m, k])
for a in ans:
    print(int(a[0]), int(a[1]))
# 7
# 5
# -1 10 -1 12 -1
# 5
# -1 40 35 -1 35
# 6
# -1 -1 9 -1 3 -1
# 2
# -1 -1
# 2
# 0 -1
# 4
# 1 -1 3 -1
# 7
# 1 -1 7 5 2 -1 5
