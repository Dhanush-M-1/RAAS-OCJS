while True:
    try:
        loi=list(map(int, input().split(' ')))

        a=loi[0]
        b=loi[1]

        numUsedCandles=0
        numHours=0

        while a>0 and numUsedCandles<b:
            a-=1
            numUsedCandles+=1

            if numUsedCandles>=b:
                numUsedCandles-=b
                a+=1

            numHours+=1

        print(numHours)

    except (EOFError, ValueError):
        exit()
