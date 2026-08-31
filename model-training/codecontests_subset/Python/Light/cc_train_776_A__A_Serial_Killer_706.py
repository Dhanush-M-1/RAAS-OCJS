def solve(a, b, c, d):
    if a == c: a = d
    elif a == d: a = c
    elif b == c: b = d
    else: b = c
    return a, b


def main():
    a, b = input().split()
    print(a, b)

    n = int(input()) 
    for _ in range(n):
        c, d = input().split()
        a, b = solve(a, b, c, d)
        print(a, b)

main()
