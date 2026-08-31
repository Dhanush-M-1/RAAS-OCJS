# stepic Задача 1
# N = int(input())
# arr = []
# s_arr = 0
# for i in range(N):
#     help_arr = list(map(int, input().split()))
#     arr.append(help_arr)
#
# for i in range(N):
#     for j in range(N):
#         if i == j:
#             s_arr += arr[i][j]
# print(s_arr)

# n = int(input())
# s = 0
# for i in range(n):
#     s += int(input().split()[i])
# print(s)

# stepic Задача 2
# N = int(input())
# arr = []
# for i in range(N):
#     arr.append(list(map(int, input().split())))
# for j in range(N):
#     for i in range(N):
#         print(arr[i][j], end=' ')
#     print()
#
# n = int(input())
# a = [input().split() for i in range(n)]
# for y in range(len(a)):
#     for x in range(len(a[y])):
#         print(a[x][y], end=' ')
#     print()

# stepic Задача 3
# N = int(input())
# a = [input().split() for i in range(N)]
# for j in range(N - 1, -1, -1):
#     for i in range(N - 1, -1, -1):
#         print(a[i][j], end=' ')
#     print()

# stepic Задача 4
# N, M = map(int, input().split())
# a = [input().split() for i in range(N)]
# for i in range(N):
#     for j in range(len(a[i])-1, -1, -1):
#         print(a[i][j], end=' ')
#     print()

# stepic Задача 5
# N, M = map(int, input().split())
# a = [input().split() for i in range(N)]
# for i in range(N-1,-1,-1):
#     for j in range(len(a[i])):
#         print(a[i][j], end=' ')
#     print()

# matrix = [list(map(int, input().split())) for i in range(5)]
# stepic Задача 6
# a = [input().split() for i in range(5)]
# for i in range(len(a)):
#     for j in range(len(a[i])):
#         if a[i][j] == '1':
#             p = abs(i - 2) + abs(j - 2)
# print(p)

# stepic Задача 7
# N, M = map(int, input().split())
# matrix = [list(map(int, input().split())) for i in range(N)]
# N_sum = [0]*N
# M_sum = [0]*M
# for i in range(N):
#     for j in range(M):
#         N_sum[i] = sum(matrix[i])
#         M_sum[j] += matrix[i][j]
# print(*N_sum)
# print(*M_sum)

# stepic Задача 8
# N = int(input())
# matrix = [list(map(int, input().split())) for i in range(N)]
# flag = 'Yes'
# for i in range(N):
#     for j in range(N):
#         if matrix[i][j] != matrix[j][i]:
#             flag = 'No'
#             break
# print(flag)

# stepic Задача 9
# N, M = map(int, input().split())
# matrix = [list(map(int, input().split())) for i in range(N)]
# max_sum = 0
# str_sum = 0
# for i in range(N):
#     if sum(matrix[i]) > max_sum:
#         max_sum = sum(matrix[i])
#         str_sum = i
# print(max_sum)
# print(str_sum)

# stepic Задача 10
# N, M = map(int, input().split())
# matrix = [list(map(int, input().split())) for i in range(N)]
# max_res = 0
# count_max_res = 0
# for i in range(N):
#     for j in range(M):
#         if matrix[i][j] > max_res:
#             max_res = matrix[i][j]
#             count_max_res = i, j
# print(max_res)
# print(*count_max_res)

# stepic Задача 11
# N, M = map(int, input().split())
# matrix = [list(map(int, input().split())) for i in range(N)]
# max_res = -1
# count_max_res = 0
# for i in range(N):
#     if max(matrix[i]) > max_res:
#         max_res = max(matrix[i])
#         count_max_res = i
#     elif max(matrix[i]) == max_res:
#         if sum(matrix[i]) > sum(matrix[count_max_res]):
#             count_max_res = i
# print(count_max_res)

# stepic Задача 12
# N, M = map(int, input().split())
# matrix = [list(map(int, input().split())) for i in range(N)]
# max_res = -1
# count_max_res = 0
# for i in range(N):
#     if max(matrix[i]) > max_res:
#         max_res = max(matrix[i])
#         count_max_res = 1
#     elif max(matrix[i]) == max_res:
#         count_max_res += 1
# print(count_max_res)
#
# n, m = map(int, input().split())
# a = [list(map(int, input().split())) for i in range(n)]
# x = []  # наилучший максимальный бросок, каждого спортсмена
# for i in range(n):
#     x.append(max(a[i]))
# print(x.count(max(x)))

# stepic Задача 13
# a = []
# flag = 'Yes'
# for i in range(4):
#     a.append([s for s in input().replace('', ' ').strip().split()])
# for i in range(1, len(a)):
#     for j in range(1, len(a[i])):
#         if a[i][j] == a[i - 1][j] == a[i][j - 1] == a[i - 1][j - 1]:
#             flag = 'No'
# print(flag)

# stepic Задача 14
# n, m = map(int, input().split())
# a = []
# b = []
# count = 0
# # a = [list(map(str, input())) for i in range(n)]
# for i in range(n):
#     a.append([s for s in input().replace('', ' ').strip().split()])
# input()
# for i in range(n):
#     b.append([s for s in input().replace('', ' ').strip().split()])
# for i in range(n):
#     for j in range(m):
#         if a[i][j] == b[i][j]:
#             count += 1
# print(count)

# stepic Задача 15
# n, x = map(int, input().split())
# a = []
# count = 0
# for i in range(1, n+1):
#     internal_a = []
#     for j in range(1, n+1):
#         k = i * j
#         internal_a.append(k)
#         if k == x:
#             count += 1
#     a.append(internal_a)
# print(count)
# for i in range(len(a)):
#     for j in range(len(a[i])):
#         print(a[i][j], end=' ')
#     print()

# n, x = map(int, input().split())
# a = []
# for i in range(1, n + 1):
#     for j in range(1, n + 1):
#         a.append(i * j)
# print(a.count(x))

n = int(input())
a = []
count = 0
for i in range(n):
    b = list(map(int, input().split()))
    a.append(b)
for i in range(n):
    for j in range(i+1, n):
        if i != j:
            if a[i][0] == a[j][1] and a[i][1] == a[j][0]:
                count += 2
            elif a[i][0] == a[j][1] or a[i][1] == a[j][0]:
                count += 1
print(count)