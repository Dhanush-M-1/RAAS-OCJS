t = int(input())

for i in range(t):
    n = int(input())
    cnt  = 0
    flag = 0
    flag1 = 0

    if n == 1:
        print(0)
        continue
    while 1:

        if n == 1:
            break

        if n%6 == 0:
            n = n//6
            if n == 1:
                break
            cnt  = cnt+1
        else:
            if (n*2)%6 == 0:
                n = n*2
                cnt = cnt+1
            else:
                print(-1)
                flag = 1
                break;

    if flag == 0:
        print(cnt+1)
