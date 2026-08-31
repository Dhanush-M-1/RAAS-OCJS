# n = int(input())
# a = []
# m = []
# for i in range(n):
#     d,k = [int(i) for i in input().split()]
#     if k % d != 0:
#         a.append(k % d)
#     else:
#         pass
# a_set = set(a)
# most = None
# most1 = 0
# for i in a_set:
#     q = a.count(i)
#     if q >= most1:
#         most1 = q
#         most = i
#         m.append(i)
# b = -1
# for i in range(len(m)):
#     if m[i] > b:
#         b = a[i]
# print(b)

# n = int(input())
# s = input()
# k = 0
# flag = False
# def decode():
#     global s,k,flag
#     s1 = re.search(r'xxx',s)
#     if s1:
#         end = s1.end()
#         k += 1
#         s = s[end:]
#         flag = True
#         decode()
#     else:
#         pass
# decode()
# if flag:
#     print(k)
# else:
#     print(0)

# import time
# start_time = time.clock()
# a1 = []
# res = []
# a = None
# while a != 0:
#     a = int(input())
#     a1.append(a)
# for i in range(1,len(a1)):
#     for j in range(1,len(a1)):
#         if (a1[i-1] * a1[j-1]) % 7 == 0 and (a1[i-1] * a1[j-1]) % 49 != 0:
#             res.append(a1[i-1] * a1[j-1])
#         else:
#             pass
# print(max(res))
# print(time.clock() - start_time)

# n = int(input())
# i = 0
# k = []
# x = []
# y = []
# while i != n:
#     a,b = [int(i) for i in input().split()]
#     x.append(a)
#     y.append(b)
#     i += 1
# for i in range(n):
#     if x[i] >= 0 and y[i] >= 0:
#         k.append(1)
#     elif x[i] <= 0 and y[i] >= 0:
#         k.append(2)
#     elif x[i] <= 0 and y[i] <= 0:
#         k.append(3)
#     else:
#         k.append(4)
# k1 = {i: k.count(i) for i in set(k)}
# k1 = max(k1.items())
# print('K = ',k1[0])
# print('M = ',k1[1])

# import time
# t = time.clock()
# n = int(input())
# n1 = n
# a = []
#
# while n1 != 0:
#     a.append(int(input()))
#     n1 -= 1
# m = a[0] + a[7]
# for i in range(n-7):
#     if a[i] + a[i+7] > m:
#         m = a[i] + a[i+7]
# print(m)
# print(time.clock()-t)

# n = int(input())
# n1 = n
# x = []
# y = []
# s = []
# while n1 != 0:
#     a,b = [int(i) for i in input().split()]
#     x.append(a)
#     y.append(b)
#     n1 -= 1
# for i in range(n):
#     if y[i] % x[i] == 0:
#         pass
#     else:
#         s.append(y[i] % x[i])
# s1 = {i: s.count(i) for i in set(s)}
# s1 = max(s1.items())
# print(s1[0])

# s1 = input()
# s2 = input()
# s1_list = list(s1)
# s2_list = list(s2)
# s1_list.sort()
# s2_list.sort()
# if s1_list == s2_list:
#     print('Yes')
# else:
#     print('No')

# k = 0
# s1 = input()
# s1_sort = {i:s1.count(i) for i in set(s1)}
# for i in range(1,len(s1)):
#     if s1[i-1] == s1[i]:
#         s1.replace(s1[i+1],'')
# print(s1)

# a = [6,3,5,7,4,2]
# m1 = 1000
# m2 = 1000
# for i in range(len(a)):
#     if a[i] < m1:
#         m2 = m1
#         m1 = a[i]
#     elif a[i] < m2:
#         m2 = a[i]
# print(m1,m2)

# import random
#
# a = ord('a')
# A = ord('A')
# z = ord('z')
# Z = ord('Z')
# c = ord('0')
# n = [chr(i) for i in range(a, z + 1)]
# for j in range(A, Z + 1):
#     n.append(chr(j))
# for i in range(c, c + 10):
#     n.append(chr(i))
# k = random.sample(n, 20)
# print(k)
# s = input()
# a = [i for i in s]
# di = {i:a.count(i) for i in a}
# di = sorted(di.items())
# print(di[0][0],'find',di[0][1])

# import random
#
# a = [input() for _ in range(3)]
# a = {i:a.count(i) for i in set(a)}
# a = sorted(a.items(), key=lambda x: x[1], reverse=True)
# print(int(a[0][0]), a[0][1])

# c = 10000
# n = 15
# a = [int(input()) for _ in range(18)]
# while n != len(a):
#     for i in range(15,len(a)):
#         if (a[i-n] * a[i]) % 2 == 0 and (a[i-n] * a[i]) < c:
#             c = a[i-n] * a[i]
#     n += 1
# print(c)

# a = input()
# b = []
# k = 0
# flag = True
# n = ['0','1','2','3','4','5','6','7','8','9']
# for i in a:
#     if i.isdigit():
#         b.append(i)
# while flag:
#     c = {i: b.count(i) for i in set(b)}
#     for i in c.items():
#         if i[1] == 1:
#             key = i[0]
#             k += 1
#     if k > 1:
#         print('No')
#         flag = False
#     if k == 1:
#         l = [0] * (len(b) + 2)
#         l[len(l) // 2] = key
#         j = 0
#         x = 1
#         while j != len(n):
#             for i in c.keys():
#                 if i == n[j]:
#                     l[(len(l) // 2) + x] = i
#                     l[(len(l) // 2) - x] = i
#                     x += 1
#             j += 1
#         for i in range(0,(len(l) // 2)-1):
#             if l[i] == key:
#                 del l[i]
#         for i in range(len(l) // 2,len(l)):
#             if l[i] == key:
#                 del l[i]
#         print(l)
#         flag = False
#     if k == 0:
#         l = [0] * (len(b))
#         x = 0
#         o = 1
#         j = 0
#         while j != len(n):
#             for i in c.keys():
#                 if i == n[j]:
#                     l[(len(l) // 2) + x] = i
#                     l[(len(l) // 2) - o] = i
#                     x += 1
#                     o += 1
#             j += 1
#         print(l)
# n = 3
# m = 10000
# mn = m + 1
# a = [int(input()) for i in range(n)]
# if sum(a) % 6 != 0:
#     print(a, sum(a))
# else:
#     for i in a:
#         if i < mn:
#             mn = i
#     if mn < m:
#         print(n-1,sum(a)-mn)
#     else:
#         print(0,0)
# n = 4
# a = [0 for _ in range(n)]
# def func(i):
#     if i < 4:
#         for k in (0,1):
#             a[i] = k
#             func(i+1)
#     else:
#         c = 0
#         if (a[0] or a[1]) and (not a[2] or not a[3]):
#             c = 1
#         print(a,c)
#
# func(0)

# a = [i for i in range(1,100)]
# #b = [2, 3, 4, 1, 6, 5, 7, 9, 8]
# #print(list(enumerate(zip(a,b))))
# print(','.join([str(i) for i in range(1,100)]))
# print(','.join(map(str,a)))

#s = input()
# a = [i for i in s]
# if a[0] == a[0].upper():
#     print(''.join(a))
# else:
#     a[0] = a[0].upper()
#     print(''.join(a))

# n, a, b, res, c = int(input()), [], [], [], 0
# while n != 0:
#     x, y = [int(i) for i in input().split()]
#     a.append(x)
#     b.append(y)
#     n -= 1
# res.append(b[0])
# for i in range(1, len(a)):
#     res.append(res[c] - a[i] + b[i])
#     c += 1
# print(max(res))


# a = [i for i in input()]
# b = [i for i in input()]
# k,l = 0,0
# flag = True
# c1 = sorted(a, key=lambda x: (str.upper(x),x))
# c2 = sorted(b, key=lambda x: (str.upper(x),x))
# if flag:
#     for i, j in zip(c1,c2):
#         if i != j:
#             if ord(i.lower()) > ord(j.lower()):
#                 print(1)
#                 flag = False
#                 break
#             elif ord(i.lower()) < ord(j.lower()):
#                 print(-1)
#                 flag = False
#                 break
#             else:
#                 pass
# if flag:
#     print(0)


# for i, j in zip(a,b):
#     k += ord(i)
#     l += ord(j)
#     if i == j.upper():
#         l = k
#     elif j == i.upper():
#         k = l
# if k > l:
#     print(1)
# elif k < l:
#     print(-1)
# else:
#     print(0)

print('+'.join(sorted(input().split('+'))))
#a = input()
#s = sorted(str.replace(a,'+',''))
#print((''.join(list(map(lambda x: x + '+', sorted(str.replace(a,'+',''))))))[:len(a):])