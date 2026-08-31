

def power_of_two(x):
    return (x and (not(x & (x - 1))))

def prime(n):

    if (n <= 1) :
        return False
    if (n <= 3) :
        return True


    if (n % 2 == 0 or n % 3 == 0) :
        return False

    i = 5
    while(i * i <= n) :
        if (n % i == 0 or n % (i + 2) == 0) :
            return False
        i = i + 6

    return True

for i in range(int(input())):
    n = int(input())
    ans = 0
    f = 1
    while True:
        while n % 6 == 0:
            n = n // 6
            ans += 1

        if n == 1:
            break

        if (2 * n) % 6 != 0:
            f = 0
            break

        n = n * 2
        ans += 1
    if f == 0:
        ans = -1

    print(ans)                    
