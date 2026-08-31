for _ in range(int(input())):
    t = int(input())
    count = 0
    imp = t
    if (t == 1):
        print(0)
    elif (t < 1):
        print(-1)
    else:
        while (t > 1 ):
            if (t % 6 == 0):
                t /= 6
                count += 1
                if (t == 1):
                    print(count)
                    break
            else: 
                t *= 2
                count += 1
                if (t >= imp * 6):
                    print(-1)
                    break
            