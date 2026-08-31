#https://codeforces.com/contest/1374/problem/B
#B. Multiply by 2, divide by 6

t = int(input())
f = [2**x for x in range(2,30)]
for i in range(t):
    n = int(input())
    count = 0
    while n != 1:
        if n in f:
            print(-1)
            break
        if (abs(n/6 - 1/3 - round(n/6)) <= 0.0000000001) or (abs(n/6 + 1/3 - round(n/6)) <= 0.0000000001):
            print(-1)
            break
        if n%6 == 0:
            n = n//6
        else:
            if n%10 == 0:
                print(-1)
                break
            n *= 2
        count += 1
    if n == 1:
        print(count)
