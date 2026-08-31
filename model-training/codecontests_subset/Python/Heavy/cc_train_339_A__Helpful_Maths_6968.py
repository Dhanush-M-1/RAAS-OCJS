# # students = [['Harry', 37.21], ['Berry', 37.21], ['Tina', 37.2], ['Akriti', 41], ['Harsh', 39]]
# # students = [['Harsh', 20], ['Beria', 20], ['Varun', 19], ['Kakunami', 19], ['Vikas', 21]]

# # students_grades = []
# # students = []

# # N = int(input())
# # for i in range(N):
# #     name = input()
# #     grades = float(input())

# #     students.append([name, grades])

# # for i in range(len(students)):
# #     students_grades.append(students[i][1])

# # lowest_grades = sorted(students_grades)
# # lowest_grades = list(dict.fromkeys(lowest_grades))[1]
# # p_lowest_grades = []

# # for i in range(len(students)):
# #     if students[i][1] == lowest_grades:
# #         p_lowest_grades.append(students[i])

# # p_sorted = sorted(p_lowest_grades)

# # for i in range(len(p_sorted)):
# #     print(p_sorted[i][0])

# # ==========================================================================

# # x = int(input()) 
# # y = int (input()) 
# # z = int(input())
# # n = int (input()) 
# # print([ [ i, j, k] for i in range( x + 1) for j in range( y + 1) for k in range(z+1) if ( ( i + j + k ) != n )])


# # n = input()
# # l = []
# # for _ in range(n):
# #     s = raw_input().split()
# #     cmd = s[0]
# #     args = s[1:]
# #     if cmd !="print":
# #         cmd += "("+ ",".join(args) +")"
# #         eval("l."+cmd)
# #     else:
# #         print l

# # import requests
# # import pandas as pd

# # post_api_url = "http://103.8.79.213:8030/public/login"
# # data_post = {
# #     'email': 'epc@ptpp.co.id',
# #     'password': 'ptPP3Pc2020$$'
# # }

# # post_request = requests.post(url=post_api_url, data=data_post)
# # post_response = post_request.json()

# # token = post_response['token']

# # get_api_url = "http://103.8.79.213:8030/api/v1/sales"
# # get_headers = {
# #     'Authorization': 'Bearer ' + token
# # }
# # get_request = requests.get(url=get_api_url, headers=get_headers)
# # get_response = get_request.json()
# # sales = get_response['sales']
# # rows = sales['rows']

# # df = pd.DataFrame(rows)
# # print(df)

# # string = "ABCDEFGHIJKLIMNOQRSTUVWXYZ"
# # width = 2
# # counter = 1

# # for i in range(len(string)):
# #     if counter % width == 0:
# #         print(string[i])
# #     else:
# #         print(string[i], end="")
# #     counter += 1

# # import sys

# # a = []
# # for arr_i in range(6):
# #     arr_temp = list(map(int, input().strip().split(' ')))
# #     a.append(arr_temp)

# # max_sum = -63

# # for i in range(4):
# #     for j in range(4):
# #         check_sum = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2]

# #         if check_sum > max_sum:
# #             max_sum = check_sum

# # print(max_sum)

# # nd = input().split()

# # n = int(nd[0])

# # d = int(nd[1])

# # a = list(map(int, input().rstrip().split()))
# # length = len(a)

# # for i in range(d):
# #     temp = a.pop(0)
# #     a.insert(length, temp)

# # for i in range(length):
# #     print(str(a[i]) + " ", end="")

# # N = int(input())

# # arr = [0 for i in range(N)]

# # for i in range(N):
# #     arr.append(int(input()))

# # for i in range(N):
# #     print(arr[i])

# # n, m = map(int,input().split())
# # pattern = [('.|.'*(2*i + 1)).center(m, '-') for i in range(n//2)]
# # print('\n'.join(pattern + ['WELCOME'.center(m, '-')] + pattern[::-1]))

# # for i in range(9):
# #     print('-', end="")

# # for i in range(1):
# #     print('.|.', end="")

# # for i in range(9):
# #     print('-', end="")

# # import string
# # alpha = string.ascii_lowercase

# # n = int(input())
# # L = []
# # for i in range(n):
# #     s = "-".join(alpha[i:n])
# #     L.append((s[::-1]+s[1:]).center(4*n-3, "-"))
# # print('\n'.join(L[:0:-1]+L))

# # N = int(input())
# # Q = int(input())
# # arr = [[0 for i in range(N)] for j in range(N)]
# # output = []

# # def add(x, y, arr):
# #     arr[x][y] = 1
# #     return arr

# # def take(x, y, arr):
# #     arr[x].pop(y)
# #     return arr

# # def count(a, b, c, d, arr, out):
# #     counter = 0
# #     for i in range(len(arr)):
# #         if i >= a and i <= c: 
# #             for j in range(len(arr[i])):
# #                 if j >= b and j <= d:
# #                     if arr[i][j] == 1:
# #                         counter += 1

# #     return out.append(counter)

# # for i in range(Q):
# #     command = input().split()

# #     if int(command[0]) == 1:
# #         add(int(command[1]), int(command[2]), arr)
# #     elif int(command[0]) == 2:
# #         take(int(command[1]), int(command[2]), arr)
# #     else:
# #         count(int(command[1]), int(command[2]), int(command[3]), int(command[4]), arr, output)

# # for i in range(len(output)):
# #     print(int(output[i]))

# # N = int(input())
# # counter = 0

# # for i in range(N):
# #     command = input()
# #     if '+'in command:
# #         counter += 1
# #     else:
# #         counter -= 1

# # print(counter)

# # fi_str = input().lower()
# # sc_str = input().lower()
# # result = 0

# # for i in range(len(fi_str)):
# #     if ord(fi_str[i]) > ord(sc_str[i]):
# #         result = 1
# #         break
# #     elif ord(fi_str[i]) < ord(sc_str[i]):
# #         result = -1
# #         break
# #     else:
# #         result = 0
    
# # print(result)

# arr = []
# step = 0

# for i in range(5):
#     n = list(map(int, input().split()))
#     arr.append(n)

# for i in range(5):
#     for j in range(5):
#         if arr[i][j] == 1:
#             pos_x = i
#             pos_y = j
# tot = 0
# arr_x = []
# def trans(pos_i, pos_j, total):
#     temp = 0
#     if abs(pos_i-2) == 0:
#         total += abs(pos_y-2)
#         temp = total
#     else:
#         if pos_i <= 2:
#             total += 1
#             trans(pos_i+1, pos_j, total)
#         else:
#             total += 1
#             trans(pos_i-1, pos_j, total)

#     arr_x.append(total)

# trans(pos_x, pos_y, tot)
# print(arr_x[0])


number = sorted(list(map(int, input().split("+"))))
for i in range(len(number)):
    if i == len(number)-1:
        print("{}".format(number[i]),end="")
    else:
        print("{}+".format(number[i]),end="")