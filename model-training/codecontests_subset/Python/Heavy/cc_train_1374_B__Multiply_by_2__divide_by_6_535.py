# c = input().split(' ')
# a = [int(y) for y in c.split(' ')]


# ar=list(map(int, input().split()))
# print(ar)
# # print(n)
# for i in range(len(ar)):
#     print(ar[i])

# a, b, c, d =map(int,input().split())
# print(a*b*c*d)

n = int(input())

l = [ input() for i in range(n)]
# print(lists)



#
# l = list(map(int, input().splitlines()))
# print(l)



def stepcount(x):
    # for j in a:
    #     x = a[j]
    i = 0
    while x > 1:
        if x < 0:
            i = -6
            print("0, {}".format(x))

        if x == 1:
            i = 0

        elif x % 6 == 0:
            x = x // 6

        elif ((x*2) % 2 == 0 and (x*2) % 3 == 0) and x > 6:
            x = x * 2

        elif x % 2 == 0 and x < 6:
            x = x * 2

        elif x % 3 == 0 and x < 6:
            x = x * 2

        else:
            return -1

        i += 1

    return i

for j in range(0, len(l)):
    print(stepcount(int(l[j])))
