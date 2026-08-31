def check(n):
    count = 0
    limit = 0
    while n > 1:
        if n % 6 == 0:
            count += 1
            n = n/6
        else:
            if (n*2) % 6 == 0:
                n = (n*2)/6
                count += 2
            else:
                n = n*2
                count += 1
                limit += 1
        if limit > 50:
            break

    if n == 1:
        return count
    else:
        return '-1'


for _ in range(int(input())):
    n = int(input())
    print(check(n))
