t = int(input())

for _ in range(t):
    
    # a = list(map(int, input.split()))
    
    # x, y, n = map(int, input.split())
    
    n = int(input())
    
    if n == 1:
        print(0)
    else:
        multiplied = 0
        cnt = 0
        while multiplied <= 1:
            if n == 1:
                print(cnt)
                break
            if n % 6 == 0:
                n //= 6
                multiplied = 0
                cnt += 1
            else:
                n *= 2
                multiplied += 1
                cnt += 1
        if multiplied == 2:
            print(-1)