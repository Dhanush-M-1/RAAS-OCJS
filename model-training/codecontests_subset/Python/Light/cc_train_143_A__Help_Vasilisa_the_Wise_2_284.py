r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

num = [1,2,3,4,5,6,7,8,9]

for i in range(1,10):
    x1 = i
    x2 = c1 - x1
    y1 = r1 - x1
    y2 = r2 - x2

    if(x1 != x2 and x1 != y1 and x1 != y2 and x2 != y1 and x2 != y2 and y1 != y2) and (x1 in num and x2 in num and y1 in num and y2 in num) and (d1 == (x1+y2) and d2 == (y1+x2)):
        print(x1, y1)
        print(x2, y2)
        quit()
print(-1)
