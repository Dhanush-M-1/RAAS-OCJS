def answer(price, flag):
    if flag == True:
        price //= 2
        if price % 50 != 0:
            price += price % 50
        print(price)
    else:
        print(price)


table = [[0, 300, 500, 600, 700, 1350, 1650], [6, 0, 350, 450, 600, 1150, 1500],
         [13, 7, 0, 250, 400, 1000, 1350], [18, 12, 5, 0, 250, 850, 1300],
         [23, 17, 10, 5, 0, 600, 1150], [43, 37, 30, 25, 20, 0, 500],
         [58, 52, 45, 40, 35, 15]]

while 1:
    d = int(input())
    if d == 0:
        break

    h1, m1 = map(int, input().split())
    a = int(input())
    h2, m2 = map(int, input().split())

    start = min(d, a) - 1
    end = max(d, a) - 1
    dis = table[end][start]
    price = table[start][end]

    if dis > 40:
        answer(price, False)
        continue
    else:
        if h1 == 18 or h2 == 18:
            answer(price, True)
            continue
        if h1 == 17 and m1 >= 30:
            answer(price, True)
            continue
        if h2 == 17 and m2 >= 30:
            answer(price, True)
            continue
        if h1 == 19 and m1 <= 30:
            answer(price, True)
            continue
        if h2 == 19 and m2 <= 30:
            answer(price, True)
            continue
        answer(price, False)
