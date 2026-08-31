# 1000 999 1000 1000 998
#2
#1 1 1 0 0
#1
#12 4 12 4 1
#3
#15 1 100 0 0
#15
#1000 2 2 5 1
#999
c, v0, v1, a, l =[int(x) for x in input().split(' ')]
d = 0
read = v0
while 1:
    d +=1
    c -= read
    if c <= 0:
        break
    c+=l
    read+=a
    if read > v1:
        read = v1
print(d)







# def soulition(c,v0,v1,a,l):
#     days = 0
#     count = 0
#     i = 1
#     while i < c + 1 :
#         if c == v0:
#             if v0 <= v1:
#                 return int(c / v0)
#         else:
#             if c < v0:
#                 return (v0)
#             elif c > v0:
#                 if v0 <= v1:
#                     days = v0 + i * a - l
#                     if days != c:
#                         days -=1
#                     elif days == c:
#                         print(days)
#
#                 else:
#                     v0 = v1
#                     days = abs(v0 + i * a - l)
#                     if days >= c:
#                         return days - c
#         i+=1
#     return days
# if __name__ == '__main__':
#     c, v0, v1, a, l =[int(x) for x in input().split(' ')]
#     # print(soulition(c,v0,v1,a,l))
#     soulition(c,v0,v1,a,l)
