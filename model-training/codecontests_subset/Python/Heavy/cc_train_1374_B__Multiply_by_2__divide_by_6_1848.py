def sum1(n): # 求一个数各位数的和
    l = len(n)
    sum = 0
    for i in range(l):
        if (n[i] != 'b'): # 兼容二进制
            sum += int(n[i])
    return sum


n = int(input())
for i in range(n):
    num = int(input())
    bnum = bin(num)
    count3 = 0
    while 1:
        if num % 3 == 0:
            num /= 3
            count3 += 1
            continue
        else:
            break
    bbnum = bin(int(num))
    if sum1(str(bbnum)) == 1:
        count2 = len(str(bbnum)) - 3
        if count2 > count3:
            print(-1)
        else:
            print(2 * count3 - count2)
    else:
        print(-1)