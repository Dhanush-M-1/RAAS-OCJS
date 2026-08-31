n = int(input())
s1 = input().split(' ')
s2 = input().split(' ')
s3 = input().split(' ')
s1 = list(map(int, s1))
s1.sort()
s2 = list(map(int, s2))
s2.sort()
s3 = list(map(int, s3))
s3.sort()

F = 0
for i in range(len(s2)):
    if s1[i] != s2[i]:
        print(s1[i])
        F = 1
        break
if F == 0:
    print (s1[-1])

F = 0
for i in range(len(s3)):
    if s2[i] != s3[i]:
        print(s2[i])
        F = 1
        break
if F == 0:
    print (s2[-1])

# l = 0
# u = len(s2)
#
# while True:
#     m = l+u//2
#     if (s1[m] == s2[m]) and (s1[m+1] != s2[m+1]):
#         print (s1[m+1])
#         break
#     if s1[m] == s2[m]:
#         l = m
#     else:
#         u = m
#     if m == l:
#         print (s1[-1])
#         break
#
# l = 0
# u = len(s3)
#
# while True:
#     m = l+u//2
#     if (s2[m] == s3[m]) and (s2[m+1] != s3[m+1]):
#         print (s2[m+1])
#         break
#     if s2[m] == s3[m]:
#         l = m
#     else:
#         u = m
#     if m == l:
#         print (s2[-1])
#         break

