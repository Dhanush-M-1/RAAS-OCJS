for _ in range(int(input())):
    n=int(input())
    count=0
    if n==1:
        print(0)
    else:
        while True:
            if n % 6 == 0:
                count += 1
                n = n // 6
            else:
                if (n * 2) % 6 == 0:
                    count += 2
                    n = n * 2
                    n = n // 6
                else:
                    print(-1)
                    break
            if n == 1:
                print(count)
                break
 