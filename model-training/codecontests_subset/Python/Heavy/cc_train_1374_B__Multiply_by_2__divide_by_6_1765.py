t = int(input())
s = []
i = 2
while i < 10**9:
    s.append(i)
    i = i * 2

for t1 in range (t):
    n = int(input())
    if n == 1:
        print(0)
    else:
        y = 0
        if n in s:
            print(-1)
            continue
        while True:
            while n % 6 == 0:
                n = n / 6
                y += 1
            if n == 1:
                break
            n *= 2
            y += 1
            if n > 10**9:
                y = -1
                break

        print(y)