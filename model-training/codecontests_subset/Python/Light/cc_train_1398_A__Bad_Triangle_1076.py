# 3
# 7
# 4 6 11 11 15 18 20
# 4
# 10 10 10 11
# 3
# 1 1 1000000000
def subString(test_str):
    res = [test_str[i: j] for i in range(len(test_str))for j in range(i + 1, len(test_str) + 1)]
    return res

for i in range(int(input())):
    n = int(input())
    l =list(map(int,input().split()))

    if l[0]+l[1] > l[n-1]:
        print(-1)
    else:
        print("{} {} {}".format(1,2,n))






