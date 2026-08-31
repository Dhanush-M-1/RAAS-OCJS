def solve(a, b, c, d):
    if a == c: a = d
    else: b = d
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
