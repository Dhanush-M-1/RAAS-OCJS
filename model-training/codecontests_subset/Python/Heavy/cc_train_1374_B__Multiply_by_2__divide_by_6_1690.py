t = int(input())
for i in range(t):
    n = int(input())
    if n == 1:
        print(0)
    elif n % 3 == 0:
        zwei = 0
        drei = 0
        while n % 2 == 0:
            zwei += 1
            n //= 2
        while n % 3 == 0:
            drei += 1
            n //= 3

        if n != 1:
            # contain other factors
            print(-1)
        elif zwei > drei:
            # more 2 than 3
            print(-1)
        else:
            # only contain 2 and 3
            print(drei + drei - zwei)
    else:
        print(-1)