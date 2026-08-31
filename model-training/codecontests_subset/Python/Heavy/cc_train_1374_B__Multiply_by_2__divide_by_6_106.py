t = int(input())

for i in range(t):
    active = True

    n = int(input())
    counter = 0
    if n == 1:
        active = False
        print(0)
    elif n == 2:
        active = False
        print(-1)
    else:
        while n != 1:
            if n % 6 == 0:
                n /= 6
                counter += 1
            else:
                n *= 2
                counter += 1
            
            if n > 1000000000:
                print(-1)
                active = False
                break

    if active == True:
        print(counter)
