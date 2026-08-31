import math
testcases = int(input())
for i in range(testcases):
    n = int(input())
    count = 0
    steps = 0
    if n == 1:
        print(0)
    else:
        while n != 1:
            if count == 2:
                print(-1)
                steps = 0
                break
            if n % 6 == 0:
                n = int(n / 6)
                count = 0
            else:
                n = n * 2
                count += 1
            steps += 1

        if steps != 0:
            print(steps)





