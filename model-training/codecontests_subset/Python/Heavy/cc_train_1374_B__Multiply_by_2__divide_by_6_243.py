powers = [2**x for x in range(1,31)]
t = int(input())
for x in range(t):
    n = int(input())
    if n==1:
        print(0)
        continue
    elif n%3!=0:
        print(-1)
        continue
    else:
        temp = n
        steps = 0
        flag = 0
        while(temp > 1):
            if (temp % 2!=0):
                temp *= 2
                steps += 1
            if (temp % 6 == 0):
                temp /= 6
                steps += 1
            if (temp == 1):
                flag = 1
                break
            elif (temp%3!=0):
                break
        if (flag == 0):
            print(-1)
        else:
            print(steps)