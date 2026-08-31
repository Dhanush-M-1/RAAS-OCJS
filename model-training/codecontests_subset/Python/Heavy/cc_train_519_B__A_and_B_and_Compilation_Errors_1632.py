########################################

#             C. Exams                 #

########################################

# n = int(input())
# a = []
# for i in range(n):
#     a.append(list(map(int, input().split())))
# a.sort()
# ch = min(a[0])
# for i in range(1, n):
#     if(ch > a[i][1]):
#         ch = a[i][0]
#     else:
#         ch = a[i][1]

# print(ch)

########################################

#        C. Drazil and Factorial       #

########################################

# ar = [[0], [1], [2], [3], [3, 2, 2], [5],
#       [5, 3], [7], [7, 2, 2, 2], [7, 3, 3, 2]]
# n = int(input())
# num = input()
# ans = []
# for i in num:
#     if(int(i) > 1):
#         for j in ar[int(i)]:
#             ans.append(j)
# ans = sorted(ans, reverse=True)
# print(''.join(str(x) for x in ans))

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
e = 0
f = 0
g = 0
for i in a:
    e = e+i
for j in b:
    f = f+j
for k in c:
    g = g+k

v = e-f
l = f-g
print(v)
print(l)
