# # start = []
# # maximum = 0
# # arr = input()
# # maxtotal = 0
# # hold = 0
# # mapping = {"[":"]", "(":")"}
# #
# # finishing = 0
# # once = 0
# # starting = 0
# # total = 0
# # flag =True
# # for i in range(len(arr)):
# #     if arr[i] in ["(","["]:
# #         if flag:
# #             start.clear()
# #             total = 0
# #             hold = 0
# #             flag = False
# #         start.append(arr[i])
# #
# #
# #
# #     else:
# #         if start:
# #             now = start.pop()
# #             if mapping[now] != arr[i]:
# #
# #                 hold = 0
# #                 total = 0
# #                 start.clear()
# #             else:
# #
# #                 if now == "[":
# #                     hold += 1
# #                 total += 1
# #                 if maximum < hold or (maximum == hold and total > hold):
# #                     maximum = hold
# #                     maxtotal = total
# #                     finishing = i
# #                     starting = finishing-(total*2-1)
# #
# #
# #         else:
# #             hold = 0
# #             total = 0
# #
# #     print(start, maximum, maxtotal,total, starting, finishing, i, arr[i], "--")
# #
# #
# #
# #
# #
# #
# # if (maximum < hold or (maximum == hold and total > hold)) and not start:
# #     maximum = hold
# #     finishing = i+1
# #     maxtotal = total
# #     starting = i - (maxtotal * 2 - 1)
# #
# #     hold = 0
# #
# # print(starting, finishing)
# # print(maximum)
# #
# # print(arr[starting:finishing+1] if starting != finishing else "")
#
# #
# # mapping = {"[": "]", "(": ")"}
# # stack = []
# #
# # arr = input()
# #
# # everything = []
# #
# #
# # for i in range(len(arr)):
# #
# #     if arr[i] in ["(", "["]:
# #         stack.append([arr[i], i])
# #
# #     else:
# #         if stack:
# #             now = stack.pop()
# #             if mapping[now[0]] != arr[i]:
# #
# #                 stack.clear()
# #
# #             else:
# #                 everything.append([now[1], i])
# #
# #
# #
# # print(everything)
# # prev = []
# # i = 0
# # while i < len(everything):
# #     print(arr[max_end - (2 * ttl_max - 1):max_end + 1], everything[i], prev)
# #     cur = prev if prev else everything[i]
# #     try:
# #         if cur[0] > everything[i+1][0] and cur[1] < everything[i+1][1]:
# #             cur_ttl = everything[i+1][3]
# #             cur_sqr = everything[i+1][2]
# #             if sq_max < cur_sqr or (sq_max == cur_sqr and ttl_max < cur_ttl):
# #                 sq_max = cur_sqr
# #                 ttl_max = cur_ttl
# #                 max_end = everything[i+1][1]
# #             prev = [everything[i+1][0],everything[i+1][1],cur_sqr,cur_ttl]
# #             i+=1
# #         elif cur[1]+1 == everything[i+1][0]:
# #             cur_ttl = everything[i+1][3] + cur[3]
# #             cur_sqr = everything[i+1][2] + cur[2]
# #             if sq_max < cur_sqr or (sq_max == cur_sqr and ttl_max < cur_ttl):
# #                 sq_max = cur_sqr
# #                 ttl_max = cur_ttl
# #                 max_end = everything[i+1][1]
# #             prev = [cur[0], everything[i + 1][1], cur_sqr, cur_ttl]
# #             i+=1
# #         else:
# #             prev = []
# #
# #     except:
# #         pass
# #     cur_ttl = cur[3]
# #     cur_sqr = cur[2]
# #     if sq_max < cur_sqr or (sq_max == cur_sqr and ttl_max < cur_ttl):
# #         sq_max = cur_sqr
# #         ttl_max = cur_ttl
# #         max_end = cur[1]
# #     i += 1
# #
# # print(sq_max)
# # print(arr[max_end - (2 * ttl_max - 1):max_end + 1])
#
#
# start = []
# maximum = 0
# arr = input()
# maxtotal = 0
# hold = 0
# mapping = {"[":"]", "(":")"}
#
# finishing = 0
# once = 0
# starting = 0
# total = 0
# flag =True
# everything = []
# for i in range(len(arr)):
#     if arr[i] in ["(","["]:
#         if flag:
#             start.clear()
#             total = 0
#             hold = 0
#             flag = False
#         start.append(arr[i])
#
#
#
#     else:
#         if start:
#             now = start.pop()
#             if mapping[now] != arr[i]:
#
#                 flag = True
#                 hold = 0
#                 total = 0
#                 start.clear()
#             else:
#                 flag = True
#                 if now == "[":
#                     hold += 1
#                 total += 1
#                 if total != 0:
#                     maximum = hold
#                     maxtotal = total
#                     finishing = i
#                     starting = finishing-(total*2-1)
#                     everything.append([starting, finishing, hold, total])
#
#         else:
#             hold = 0
#             total = 0
#
#
#
#
#
#
#
#
# if (maximum < hold or (maximum == hold and total > hold)) and not start:
#     maximum = hold
#     finishing = i+1
#     maxtotal = total
#     starting = i - (maxtotal * 2 - 1)
#     everything.append([starting, finishing, hold, total])
#     hold = 0
#
# print(everything)
# print(maximum)
#
# print(arr[starting:finishing+1] if starting != finishing else "")
#
#
# ttl_max = 0
# sq_max = 0
# cur_sqr = 0
# cur_ttl = 0
# max_end = 0
# prev = []
# i = 0
# while i < len(everything):
#     print(everything[i],"--")
#     cur = prev if prev else everything[i]
#     try:
#         if cur[0] > everything[i+1][0] and cur[1] < everything[i+1][1]:
#             cur_ttl = everything[i+1][3]
#             cur_sqr = everything[i+1][2]
#             if sq_max < cur_sqr or (sq_max == cur_sqr and ttl_max < cur_ttl):
#                 sq_max = cur_sqr
#                 ttl_max = cur_ttl
#                 max_end = everything[i+1][1]
#             prev = [everything[i+1][0],everything[i+1][1],cur_sqr,cur_ttl]
#             i+=1
#         elif cur[1]+1 == everything[i+1][0]:
#             cur_ttl = everything[i+1][3] + cur[3]
#             cur_sqr = everything[i+1][2] + cur[2]
#             if sq_max < cur_sqr or (sq_max == cur_sqr and ttl_max < cur_ttl):
#                 sq_max = cur_sqr
#                 ttl_max = cur_ttl
#                 max_end = everything[i+1][1]
#             prev = [cur[0], everything[i + 1][1], cur_sqr, cur_ttl]
#             i+=1
#         else:
#             prev = []
#
#     except:
#         pass
#     cur_ttl = cur[3]
#     cur_sqr = cur[2]
#     if sq_max < cur_sqr or (sq_max == cur_sqr and ttl_max < cur_ttl):
#         sq_max = cur_sqr
#         ttl_max = cur_ttl
#         max_end = cur[1]
#     i += 1
#     print(arr[max_end - (2 * ttl_max - 1):max_end + 1], prev)
# print(sq_max)
# print(arr[max_end - (2 * ttl_max - 1):max_end + 1])

a, b = list(map(int,input().split()))
total = 0
left = 0
while a > 0:
    total += a
    left += a % b
    if left // b == 0:
        a = a//b
    else:
        a = a//b+left//b
        left = left%b

print(total)