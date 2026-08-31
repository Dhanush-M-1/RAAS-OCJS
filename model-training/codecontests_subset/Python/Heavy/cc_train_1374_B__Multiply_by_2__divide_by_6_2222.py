t = int(input())
for i in range(t):
    n = int(input())
    if n == 0:
        print(-1)
    elif n == 1:
        print(0)
    else:
        s = 0
        done = False
        while not done:
            if n % 3 != 0:
                s = -1
                done = True
            else:
                if n % 2 == 0:
                    n = n / 6
                    s += 1
                else:
                    n = n / 3
                    s += 2
            if n == 1:
                done = True
        print(s)




