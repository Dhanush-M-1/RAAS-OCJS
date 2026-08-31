t = int(input())

for _ in range(t):
    n = int(input())
    if n == 1:
        print(0)
    else:
        if n % 3 != 0:
            print("-1")
        else:
            col2 = 0
            col3 = 0
            while n % 2 == 0:
                n /= 2
                col2 += 1

            while n % 3 == 0:
                n /= 3
                col3 += 1

            if n > 1:
                print('-1')

            else:
                if col2 > col3:
                    print('-1')
                else:
                    print(2*col3-col2)
