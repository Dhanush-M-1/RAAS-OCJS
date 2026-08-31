t = int(input())

for i in range(t):
    n = int(input())
    
    doubled = False
    count = 0
    while True:
        if n == 1:
            break
        if n == 2 or n == 4 or n == 5:
            count = -1
            break

        if n % 6 == 0:
            n = n / 6
            count += 1
            doubled = False
        else:
            if doubled:
                count = -1
                break
            n = n * 2
            doubled = True
            count += 1

    print(count)