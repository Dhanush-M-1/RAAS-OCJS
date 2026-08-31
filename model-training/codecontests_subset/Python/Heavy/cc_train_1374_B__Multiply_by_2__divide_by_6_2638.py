def sum1(n):
    l = len(n)
    sum = 0
    for i in range(l):
        if (n[i] != 'b'):
            sum += int(n[i])
    return sum


n = int(input())
for i in range(n):
    num = int(input())
    bnum = bin(num)
    if num == 1:
        print(0)
        continue
    if sum1(str(bnum)) == 1:
        print(-1)
        continue
    else:
        count3 = 0
        while 1:
            if num % 3 == 0:
                num /= 3
                count3 += 1
                continue
            else:
                bbnum = bin(int(num))
                if sum1(str(bbnum)) == 1:
                    count2 = len(str(bbnum)) - 3
                    if count2 > count3:
                        print(-1)
                    else:
                        print(2 * count3 - count2)
                else:
                    print(-1)
                break

