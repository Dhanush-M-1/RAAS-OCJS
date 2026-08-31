def checking(r1, r2, c1, c2, d1, d2):
    lis = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    ans = 0
    for i in range(1, 10):
        x = i
        a = r1 - x
        b = c1 - x
        c = r2 - b
        if (x != a and x != b and x != c and a != b and a != c and b != c) and (
                a in lis and b in lis and c in lis and x in lis) and (
                d1 == x + c and d2 == a + b and r1 == x + a and r2 == b + c and c1 == x + b and c2 == a + c):
            print(x, a)
            print(b, c)
            break
        ans += 1
    if ans == 9: 
        print(-1)

r1, r2 = map(int,input().split())
c1, c2 = map(int,input().split())
d1, d2 = map(int,input().split())

checking(r1, r2, c1, c2, d1, d2)
# Wed Oct 14 2020 14:12:24 GMT+0300 (Москва, стандартное время)
