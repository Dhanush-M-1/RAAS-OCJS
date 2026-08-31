# import math
# t = int(input())
# for i in range(0,t):
#     a,b,c = list(map(int,input().split()))
#
#
#
#     if (a<c):
#         if (b*a>c):
#             print("1" , b)
#
#         else:
#             print("1 -1")
#
#     else:
#         print("-1 2")




# k = int(input())
# s = 'codeforces'
# val = []
#
# for i in range(0,10):
#     val.append(1)
#
# product = 1
#
# # This below logic is the heart of the problem, how we apply it, and how i code this logic is the king.
# while(product<k):
#
#     for r in range(0,10):
#         val[r]+=1
#         product = product/(val[r]-1)
#         product = product * val[r]
#
#         if product>=k:
#             break
#
#
#
# l = list(s)
# for i in range(0,10):
#     l[i] = l[i]*val[i]
#
#     print(''.join(l[i]),end = "")



t = int(input())


for i in range(0,t):
    n = int(input())

    twos = 0
    threes = 0

    while(n%2==0):
        n = n/2
        twos+=1


    while(n%3==0):
        n = n/3
        threes+=1

    if(n!=1):
        print("-1")

    else:
        if(twos>threes):
            print("-1")
        else:
            print((threes-twos)+threes)

















