#616A
# a = input()
# b = input()
# a = a.lstrip("0")
# b = b.lstrip("0")
# a = int(a)
# b = int(b)
# # print(a,b)
# if a>b:
#     print(">")
# elif a<b:
#     print("<")
# else:
#     print("=")

#118A
# vowels = ['a', 'e', 'i', 'o', 'u']
# s = [i.lower() for i in input()]
# result = []
# for i in range(len(s)):
#     # s[i].lower()
#     if s[i] in vowels:
#         result.append("")
#     else:
#         result.append(".")
#         result.append(s[i])
# print(''.join(result))

#1293B
# n = int(input())
# ans = sum([1.0 / i for i in range(1, n+1)])
# print(ans)

#761A
# x,y = input().split()
# x = int(x)
# y = int(y)
# if x==0 and y==0:
#     print("NO")
# elif abs(x-y) <= 1:
#     print("YES")
# else:
#     print("NO")

#864A
# n = int(input())
# a = []
# d = []
# j = 0
# for i in range(n):
#     k = int(input())
#     a.append(k)
#     if k not in d:
#         d.append(k)
#         j = j + 1
# q = 0
# w = 0
# if j != 2:
#     print("NO")
# else:
#     z = d[0]
#     x = d[1]
#     for i in range(n):
#         if a[i] == z:
#             q = q + 1
#         if a[i] == x:
#             w = w + 1
#     if w != q:
#         print("NO")
#     else:
#         print("YES")
#         print(d[0], d[1])

#616B
# n, m = input().split()
# n = int(n)
# m = int(m)
# arr = [[i for i in input().split()][:m] for y in range(n)]
# max = -10
# for i in range(n):
#    mini = min(arr[i])
#    if int(mini) > int(max):
#        max = mini
#        z = i
# print(max)

#284B
n = int(input())
a = [i for i in input()][:n]
j = 0
na = 0
ni = 0
nf = 0
for i in range(n):
    if a[i] == 'A':
        na = na + 1
    elif a[i] == 'I':
        ni = ni + 1
    else:
        nf = nf + 1
for i in range(n):
    if a[i] == 'A':
        if ni == 0:
            j = j + 1
    elif a[i] == 'I':
        if ni == 1:
            j = j + 1
    else:
        pass
print(j)