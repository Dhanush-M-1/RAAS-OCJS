r1,r2 = map(int,input().split())
c1,c2 = map(int,input().split())
d1,d2 = map(int,input().split())
x = (c1 + r1 - d2) / 2
if x != int(x): 
    print(-1)
else:
    a = r1 - x
    b = c1 - x
    c = d1 - x
    if ((x == a) or (x == b) or (x == c) or (a == b) or (a == c) or (b == c)):
        print(-1)
    elif(x < 1 or x > 9 or a < 1 or a > 9 or b < 1 or b > 9 or c < 1 or c > 9):
        print(-1)
    elif b + c != r2 or a + c != c2 or a + b != d2:
        print(-1)
    else:
        print(str(int(x)) + " " + str(int(a)))
        print(str(int(b)) + " " + str(int(c)))