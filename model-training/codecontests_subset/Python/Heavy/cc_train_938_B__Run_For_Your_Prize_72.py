if __name__=="__main__":
    numPrizes = input()
    prizeInput = input().split()
    prizeInput = [int(x) for x in prizeInput]
    prizeL = [x for x in prizeInput if x <= 500000]
    prizeR = [x for x in prizeInput if x > 500000]

    l = 0
    r = 0

    if len(prizeL) > 0:
        l = prizeL[-1]

    if len(prizeR) > 0:
        r = prizeR[0]

    if len(prizeR) == 0:
        print (l - 1)

    elif len(prizeL) == 0:
        print(1000000 - prizeR[0])

    else:
        print(max(l-1, 1000000-prizeR[0]))



    # 2 5 7 250 698 989
