t = int(input())

def satisfy(a, b, c):
    return a + b > c and a + c > b and b + c > a

for case in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    done = False
    if not satisfy(a[0], a[n - 2], a[n - 1]):
        print(1, n - 1, n)
    elif not satisfy(a[0], a[1], a[n - 1]):
        print(1, 2, n)
    else:
        print(-1)
    # for i in range(2, n):
    #     if (satisfy(a[i - 2], a[i - 1], a[i])):
    #         print(i - 1, i, i + 1)
    #         done = True
    #         break
    # if not done:
    #     print(-1)