########################################

#      K-th Beautiful String           #

########################################

# for _ in range(int(input())):
#     m, n = map(int, input().split())
#     j = 1
#     i = 1
#     if(n == 2 or n == 3):
#         a = 1
#     else:
#         a = 0
#     while(j < n):
#         i += 1
#         j += i
#         if(j < n):
#             a = j
#     s = 'a'*(m)
#     # print(a)
#     i = m - i - 1
#     s = s[:i]+'b'+s[i+1:]
#     i = m - (n - a - 1) - 1
#     s = s[:i]+'b'+s[i+1:]
#     print(s)

########################################

#   B. A and B and Compilation Errors  #

########################################

n = int(input())
a = sum(list(map(int, input().split())))
b = sum(list(map(int, input().split())))
print(a-b)
c = sum(list(map(int, input().split())))
print(b-c)
