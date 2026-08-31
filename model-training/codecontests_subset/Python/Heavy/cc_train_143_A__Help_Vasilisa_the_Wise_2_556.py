def main():
    r1 = r2 = c1 = c2 = d1 = d2 = None
    h1 = h2 = h3 = h4 = 0
    for i in range(3):
        inp = list(input().split())
        if i == 0:
            r1 = int(inp[0])
            r2 = int(inp[1])
        elif i == 1:
            c1 = int(inp[0])
            c2 = int(inp[1])
        else:
            d1 = int(inp[0])
            d2 = int(inp[1])

    for i in range(1, 10, 1):
        h1 = i
        h2 = abs(r1 - h1)
        h3 = abs(c1 - h1)
        h4 = abs(c2 - h2)
        if h1 <= 9 and h2 <= 9 and h3 <= 9 and h4 <= 9 and h1 != h2 and h1 != h3 and h1 != h4 and h2 != h3 and h2 != h4 and h3 != h4 and h1 != 0 and h2 != 0 and h3 != 0 and h4 != 0 and h1+h4 == d1 and h2+h3 == d2 and h1+h2 == r1 and h3+h4 == r2 and h1+h3 == c1 and h2+h4 == c2:
            print(h1, h2)
            print(h3, h4)
            return

    print(-1)



if __name__ == '__main__' : main()
