t = int(input())

def second(a, b, c):
    ans = 0
    while b >= 2 and a > 0:
        ans += 3
        b -= 2
        a -= 1

    while c >= 2 and b > 0:
        ans += 3
        c -= 2
        b -= 1

    return ans

def first(a, b, c):
    ans = 0
    while c >= 2 and b > 0:
        ans += 3
        c -= 2
        b -= 1

    while b >= 2 and a > 0:
        ans += 3
        b -= 2
        a -= 1

    return ans

for w in range(t):
    a, b, c = [int(i) for i in input().split()]

    print(max(first(a, b, c), second(a, b, c)))