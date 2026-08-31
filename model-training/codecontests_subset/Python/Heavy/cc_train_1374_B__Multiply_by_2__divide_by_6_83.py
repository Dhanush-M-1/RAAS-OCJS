# n, k, p = map(int, input().split())
# arr = list(map(int, input().split()))


def delim(n):
    ans = 0
    while n % 2 == 0:
        ans += 1
        n = n // 2
    return ans

def count(a):
    ans = 0
    while a % 3 == 0:
        ans += 1
        a /= 3
    return ans


t = int(input())
for i in range(t):
    a = int(input())
    if a == 1:
        print(0)
    else:
        if a % 3 == 0:
            ans = count(a)
            much = delim(a)
            if ans < much:
                print(-1)
            else:
                h = a
                h *= 2 ** (ans - much)
                for j in range(ans):
                    h /= 6
                if h == 1 or h == 1.0:
                    print(ans + ans - much)
                else:
                    print(-1)
        else:
            print(-1)

