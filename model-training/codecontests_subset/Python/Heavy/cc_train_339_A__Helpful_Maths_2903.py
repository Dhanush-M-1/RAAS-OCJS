# a = input()
# # list_int = a.split("+")
# # list_int.sort()
# # for i in list_int:
# #     if list_int.index(i) == len(list_int)-1:
# #         print(i)
# #     else:
# #         print(i, end="+")
# # print(''.join(sorted(a)))
# s = ''.join(sorted(a))
# # print(s.replace("+", ""))
# re = s.replace("+", "")
# for i in re:
#     # print(i)
#     if i == re[-1]
#     print(i)
#     else:
#         print(i, end="+")
# # print(x+"+" for x in re)

a = input()
a = (''.join(sorted(a))).replace("+", "")
# print(a)
for i in range(len(a)):
    if i == len(a)-1:
        print(a[i], end="")
    else:
        print(a[i], end="+")
