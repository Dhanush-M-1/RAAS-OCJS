for _ in range(int(input())):
    a = int(input())
    if a == 1:
        print(0)
    else:
        three = 0
        two = 0
        while a % 3 == 0:
            a//=3
            three += 1
        while a % 2 == 0:
            a//=2
            two += 1
        if a > 1:
            print(-1)
        else:
            if three == 0:
                print(-1)
            elif two > three:
                print(-1)
            else:
                res = three + (three-two)
                print(res)