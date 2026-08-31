import sys
import math

input = sys.stdin.readline

# big_number = 10000000
# n, p, w, d = 627936103814, 4254617095171609, 45205, 1927
# x, y, z = 94118284813, 15672, 533817803329
# gcd_w_d = math.gcd(w, d)

# x0 = 1323


#print(94118284813 + 15672 - 627936102301, 'blaaaa')
# print(w*x+d*y)
# print(w*x+d*y - p)
# print(x+y+z-n)

def get_answer():

    n, p, w, d = map(int, input().split())

    gcd_w_d = math.gcd(w, d)

    if p == 0:
        print(0, 0, n)
        return


    if (p % gcd_w_d != 0) or (p > w*n + d*n):
        print(-1)
        return

    x0 = -1
    for i in range(0, int(p/w)):
        cur_x = p - w * i
        if cur_x % d == 0:
            x0 = i
            break
    # print(x0, 'x000')       
    if x0 == 0:
        
        if p%w == 0:
            x = int(p/w)
            if x <= n:
                y = int((p - w*x) / d)
                print(x, y, n - x - y)
            else:
                print(-1)
        
        else:

            x = int(p/w)
            if x <= n:
                if (p - w*x) % d == 0:
                    y = int((p - w*x) / d)
                    print(x, y, n - x - y)
                    return


            x = 0
            y = int(p/d)
            if y > n:
                print(-1)
            else:
                print(x, y, n - x - y)
        return

    if x0 == -1:
        x = 0
        if p % d == 0:
            y = int(p/d)
            if y > n:
                print(-1)
                return
            else:
                print(0, y, n-y)
        else:
            print(-1)
        return

    # print(x0, 'x0000')
    x = -1
    y = -1
    tmp_multiplier = int(d / gcd_w_d)
    max_x = int(p/w)
    i = (max_x - x0) / tmp_multiplier
    i = int(i)

    x = x0 + i * tmp_multiplier
    #print(x0, 'x0000')
    #print(x, 'xxxxx')
    
    if p - w*x < 0:
        print(-1)
        return  

     
    #print((p - w*x) / d)
    y = int((p - w*x) / d)
    #print(y, 'yyyyy')
    #print(x+y-n, 'aaaaaa')

    if x + y > n:
        print(-1)
        return         


    # for i in range(0, n):
    #     x = x0 + i * (int(d / gcd_w_d))
    #     if p - w*x < 0:
    #         x = -1
    #         break
    #     y = int((p - w*x) / d)
    #     if x + y <= n:
    #         break

    print(x, y, n - x - y)

get_answer()
# elements_array = list(map(int, input().split()))

# elements_array.sort()

# answer_elements_list = [(big_number, -1)]*(elements_array[-1] + 1)

# for element in elements_array:
#     cur_element = element
#     i = 0
#     while cur_element >= 0:
#         if answer_elements_list[cur_element][0] < big_number:
#             if answer_elements_list[cur_element][1] < k:
#                 new_tuple = (answer_elements_list[cur_element][0] + i, answer_elements_list[cur_element][1] + 1)
#                 answer_elements_list[cur_element] = new_tuple
#             else:
#                 break
#         else:
#             answer_elements_list[cur_element] = (i, 1)
#         if cur_element == 0:
#             break
#         cur_element = int(cur_element / 2)
#         i += 1

# best_result = big_number
# for value in answer_elements_list:
#     if value[1] < k:
#         continue
#     cur_operations = value[0]
#     best_result = min(best_result, cur_operations)

# print(best_result)