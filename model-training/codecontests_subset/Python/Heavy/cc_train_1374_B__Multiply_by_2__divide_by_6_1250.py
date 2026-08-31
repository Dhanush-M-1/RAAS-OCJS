n = int(input())
for i in range(n):
    a = int(input())
    if a == 1:
        print(0)
    else:
        op = 0
        if a % 2 == 0 or a % 3 == 0:
            while a % 6 == 0:
                a = a // 6
                op += 1
            if a == 1:
                print(op)
            elif a % 3 != 0:
                print(-1)
            else:
                k = 0
                while a % 3 == 0:
                    k += 1
                    a = a // 3
                if(a == 1):
                    op += k * 2
                    print(op)
                else:
                    print(-1)

        else:
            print(-1)