def g(r, d):
    c = (r + d) % d
    return (r + d) - c

def solve(l, r, d):
    if d < l:
        return d
    else:
        return g(r, d)

def main():
    n = int(input())
    for i in range(n):
        l, r, d = map(int, input().split())
        answer = solve(l, r, d)
        print(answer)


if __name__ == "__main__":
    main()
