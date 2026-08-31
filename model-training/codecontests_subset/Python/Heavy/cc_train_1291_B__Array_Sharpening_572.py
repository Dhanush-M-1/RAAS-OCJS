
t = int(input())

# def go(a):
#     possible = [True] * n
#
#     for i in range(n):
#         x = a[i] - 1
#         for j in range(i - 1, -1, -1):
#             if x < 0:
#                 possible[i] = False
#                 break
#             if a[j] <= x:
#                 x = a[j]-1
#             else:
#                 x -=1
#         if not possible[i]:
#             continue
#
#         y = a[i] - 1
#         for j in range(i + 1, n):
#             if y < 0:
#                 possible[i] = False
#                 break
#             if a[j] <= y:
#                 y = a[j]-1
#             else:
#                 y -=1
#
#         if possible[i]:
#             return 'Yes'
#     return 'No'

def go(a):
    n = len(a)
    left = [False]*n
    right = [False]*n

    for i in range(n):
        if a[i] >= i:
            left[i] = True
        else:
            break

    for i in range(n-1,-1,-1):
        if a[i] >= n-i-1:
            right[i] = True
        else:
            break

    for i in range(n):
        if left[i] and right[i]:
            return 'Yes'

    return 'No'


for _ in range(t):
    n = int(input())
    a = list(map(int ,input().split()))

    if n== 1:
        print('Yes')
    else:
        print(go(a))
