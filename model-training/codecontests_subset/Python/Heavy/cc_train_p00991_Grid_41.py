# Edit: 2014/09/09
# Lang: Python3
# Time: .00s

from math import factorial

if __name__ == "__main__":
    r, c, ar, ac, br, bc = map(int, input().strip("\n").split(" "))
    maxans = 100000007  # 100,000,007

    # tate Row
    dr = min(abs(br - ar), r - abs(br - ar))
    if 2 * dr == r:
        gainr = 2
    else:
        gainr = 1

    # yoko Column
    dc = min(abs(bc - ac), c - abs(bc - ac))
    if 2 * dc == c:
        gainc = 2
    else:
        gainc = 1

    #dr = int(dr)
    #dc = int(dc)
    #gainr = int(gainr)
    #gainc = int(gainc)

    # print(dr, dc)
    # print(gainr, gainc)

    #ans1 = factorial(dr+dc)
    #print("ans1",ans1)
    #print("type",type(ans1))

    #ans2 = factorial(dr)
    #print("ans2",ans2)
    #print("type",type(ans2))

    #ans3 = factorial(dc)
    #print("ans3",ans3)
    #print("type",type(ans3))

    #ans4 = ans1//ans2//ans3*gainr*gainc
    #print("ans4",ans4)
    #print("type",type(ans4))

    #ans = ans4
    ## ans = factorial(dr + dc) / factorial(dr) / factorial(dc) # * gainr * gainc
    # python overflow error integer division result too large for a float

    ans = factorial(dr + dc) // factorial(dr) // factorial(dc) * gainr * gainc


    # t = 1
    #for i in range(dr, dr + dc):
    #print(t)
    #    t *= i
    #ans = t / factorial(dc) * gainr * gainc

    #print(ans)
    #print(ans, type(ans))
    print(ans % maxans)

    # print("34807775")
    #67,352,549