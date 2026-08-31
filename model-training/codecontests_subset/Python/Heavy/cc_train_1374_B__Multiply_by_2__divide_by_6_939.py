########################################

#            SUBTRACTIONS              #

########################################

# for _ in range(int(input())):
#     a, b = map(int, input().split())
#     c = 0
#     while(min(a, b) != 0):
#         ma = max(a, b)
#         mi = min(a, b)
#         a = mi
#         b = ma
#         c += b//a
#         b = b % a
#     print(c)

########################################

#             CANDIES                 #

########################################

# from math import log2, floor, ceil
# for _ in range(int(input())):
#     a = int(input())
#     c = ceil(log2(a))
#     # print(c)
#     for i in range(c, 0, -1):
#         if((a//((2**i)-1)) == ceil(a/((2**i)-1))):
#             print((a//((2**i)-1)))
#             break

########################################

#         VASYA AND SOCKS              #

########################################

# a, b = map(int, input().split())
# c = (a-1)//(b-1)
# print(a+c)

########################################

#       MULTIPLY BY 2, DIVIDE BY 6     #

########################################

for _ in range(int(input())):
    n = int(input())
    if(n == 1):
        print(0)
    else:
        op = 0
        while(True):
            if(n % 6 == 0):
                n = n//6
                op += 1
            elif((n-3) % 6 == 0):
                n = (n*2)//6
                op += 2
            else:
                op = -1
                break
            if(n == 1):
                break
        print(op)
