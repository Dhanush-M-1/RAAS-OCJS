
t = int(input())

for i in range(t):

    a, b, c = map(int, input().split())

    if c < a:

        print(c)

    elif c > b:

        print(c)

    else:

        print(c + ((b - c) // c + 1) * c)
