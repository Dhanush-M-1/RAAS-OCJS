n = int(input())

for i in range(n):
    x = list(map(int, input().split(" ")))
    a = x[0]
    b = x[1]
    c = x[2]

    if c < a or c > b:
        print(c)
    else:
        i = b // c
        while True:
            if i * c > b:
                print(i * c)
                break
            else:
                i += 1
