def solve():
    n = int(input())
    num = [int(x) for x in input().split()]
    number = {}
    for i in num:
        if (i not in number):
            number[i] = 1
        else:
            number[i] += 1
    number = sorted(number.items(), reverse = True)
    g = number[0][1]
    s, b = 0, 0
    p = 0
    while (s <= g):
        if (p == len(number) - 1):
            print(0, 0, 0)
            return
        p += 1
        s += number[p][1]
    while (b <= g):
        if (p == len(number) - 1):
            print(0, 0, 0)
            return
        p += 1
        b += number[p][1]
    if (g + s + b > n//2):
        print(0, 0, 0)
        return    
    while (True):
        p += 1
        if (g + s + b + number[p][1] <= n//2):
            b += number[p][1]
        else:
            break
    print(g, s, b)
t = int(input())
for i in range(t):
    solve()