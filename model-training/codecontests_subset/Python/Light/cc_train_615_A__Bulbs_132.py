def main():
    n, m = map(int, input().split())
    a = set({})

    for i in range(n):
        b = list(map(int, input().split()))
        a.update(b[1:])

    print("YES" if(len(a) == m) else "NO")

if __name__ == "__main__":
    main()
