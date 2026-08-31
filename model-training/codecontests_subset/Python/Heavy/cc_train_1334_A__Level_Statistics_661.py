T = int(input())
ans = ['YES'] * T
for t in range(T):
    n = int(input())
    ar = []
    for i in range(n):
        ar.append([int(j) for j in input().split(' ')])
    i, go = 1, True
    if ar[0][0] < ar[0][1]:
        ans[t], go = 'NO', False
    while go and i < n:
        if ar[i][0] >= ar[i - 1][0]:
            if ar[i][0] - ar[i - 1][0] < ar[i][1] - ar[i - 1][1]:
                ans[t], go = 'NO', False
            elif ar[i][1] - ar[i - 1][1] < 0:
                ans[t], go = 'NO', False
        elif ar[i][0] < ar[i - 1][0]:
            ans[t], go = 'NO', False
        elif ar[i][0] < ar[i][1]:
            ans[t], go = 'NO', False
        i += 1
for a in ans:
    print(a)

# T = int(input())
# ans = []
# for t in range(T):
#     n, x = [int(i) for i in input().split(' ')]
#     A = [int(i) for i in input().split(' ')]
#     a = 0
#     s = 0
#     A.sort()
#     for i in range(n - 1, -1, -1):
#         s += A[i]
#         if s >= x * (n - i):
#             a = n - i
#     ans.append(a)
# for a in ans:
#     print(a)

#
# def blow(i, A, B, killed):
#     j = (i + 1) % n
#     if j not in killed:
#         A[j] = A[j] - min(A[j], B[i])
#         if A[j] <= 0:
#             killed.add(j)
#             blow(i, A, B, killed)
#     return killed
#
#
# def shot(i, killed, A, B):
#     A[i] -= 1
#     if A[i] <= 0:
#         killed.add(i)
#         killed = blow(i, A, B, killed)
#     return killed

#
# T = int(input())
# ans = []
# for t in range(T):
#     n = int(input())
#     A, B = [], []
#     for i in range(n):
#         a, b = [int(j) for j in input().split(' ')]
#         A.append(a)
#         B.append(b)
#     killed = set()
#     bullet = 0
#     i = 0
#     while len(killed) < n:
#         print(i, killed)
#         killed = shot(i, killed, A, B)
#         bullet += 1
#         i = (i + 1) % n
#         while i % n in killed:
#             i = (i + 1) % n
#         print('end', bullet, killed)
#     ans.append(bullet)
#     print(ans)
# for a in ans:
#     print(a)

#
# def f(A):
#     ans = [A[0]]
#     for i in range(1, len(A)):
#         if A[i] > ans[-1]:
#             ans.append(A[i])
#     return ans

#
# n = int(input())
# a = [int(i) for i in input().split(' ')]
# p = [int(i) for i in input().split(' ')]
# m = int(input())
# b = [int(i) for i in input().split(' ')]
# c = 0
# if m > n:
#     print('NO')
# else:
#     x = f(a)
#     for i in range(m):
#         if b[i] != x[i]:
#             idx = a.index(b[i])
#             if idx == -1:
#                 print('NO')
#                 break
#             j = idx - 1
#             if j > 0:
#                 while a[j] != x[j]:
#                     c += p[j]
#                     j -= 1
