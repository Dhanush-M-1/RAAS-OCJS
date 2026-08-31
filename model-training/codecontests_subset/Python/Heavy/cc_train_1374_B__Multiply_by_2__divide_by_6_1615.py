f = int(input())
l = []
for _ in range(f):
    n = int(input())
    count = 0
    run = True
    if n == 1:
        l.append(count)
    else:
        while run:
            if n % 6 == 0:
                count += 1
                n /= 6
            else:
                count += 1
                n *= 2

            if n == 1:
                l.append(count)
                run = False

            if count > 100:
                l.append(-1)
                run = False
for i in l:
    print(i)