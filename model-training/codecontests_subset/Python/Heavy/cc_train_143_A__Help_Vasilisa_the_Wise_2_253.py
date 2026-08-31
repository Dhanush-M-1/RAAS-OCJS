import math

def main():
    r1,r2 = [int(x) for x in input().split()]
    c1,c2 = [int(x) for x in input().split()]
    d1,d2 = [int(x) for x in input().split()]
    a = math.floor((r1 - c2 + d1)/2)
    b = r1 - a
    c = c1 - a
    d = d1 - a
    if a == b or a == c or a == d or b == c or b == d or c == d:
        print(-1)
    elif (a + b) != r1 or (c + d) != r2 or (a + c) != c1 or (b + d) != c2 or (a + d) != d1 or (c + b) != d2:
        print(-1)
    elif a > 9 or b > 9 or c > 9 or d > 9:
        print(-1)
    elif a == 0 or b == 0 or c == 0 or d == 0:
        print(-1)
    else:
        print(a, b)
        print(c, d)

if __name__ == '__main__':
    main()
