t = int(input())
for i in range(t):
    n, l, r = map(int, input().split())
    if l == n * (n - 1) + 1:
        print(1)
    else:
        x = 1
        summa = x * 2 * n
        rasn = x * (x + 1)
        while summa - rasn < l:
            summa += 2 * n
            rasn = (rasn // x) * (x + 2)
            x += 1
        x -= 1
        summa -= 2 * n
        rasn = (rasn // (x + 2)) * x
        first = x + 1
        second = (l - summa + rasn + 1) // 2 + first
        if (l - summa + rasn) % 2 == 0:
            print(second, end=" ")
            if second == n:
                first += 1
                second = first + 1
            else:
                second += 1
            ind = l + 1
        else:
            ind = l
        while ind + 1 <= r:
            print(first, second, end=" ")
            if second == n:
                first += 1
                second = first + 1
            else:
                second += 1
            ind += 2
        if ind == r:
            if r == n * (n - 1) + 1:
                print(1)
            elif second == n:
                print(first)
            else:
                print(first)
        else:
            print()
