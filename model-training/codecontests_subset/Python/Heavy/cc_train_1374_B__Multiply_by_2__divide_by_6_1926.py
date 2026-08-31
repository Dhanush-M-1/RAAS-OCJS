cases = int(input())

power6 = []
for p in range(11):
    pos = 6**p
    power6.append(pos)
for i in range(cases):
    num = int(input())
    if (num in power6):
        print(power6.index(num))
    else:
        count2 = 0
        while (num%2==0):
            num = int(num/2)
            count2 += 1
        count3 = 0
        while (num%3 == 0):
            num = int(num/3)
            count3 += 1
        if (num!=1) or (count3 == 0) or (count3<count2):
            print(-1)
        else:
            print((count3 - count2) +count3)