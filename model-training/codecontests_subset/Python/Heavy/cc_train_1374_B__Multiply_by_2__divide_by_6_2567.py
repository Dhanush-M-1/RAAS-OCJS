t = int(input())
l = list()
while 0 < t:
    i = int(input())
    l.append(i)
    t -= 1
for num in l:
    count = 0
    while num > 1:
        if (num % 6) == 0:
            num = num / 6
            count = count + 1
        elif num == 1:
            break
        elif num < 1:
            count = -1
            break
        else:
            if num % 3 == 0:
                num = num * 2
                count = count + 1
            else:
                count = -1
                break
    print(count)