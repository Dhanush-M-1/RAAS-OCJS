def readline():
    return [int(c) for c in input().split()]

def main():
    n, = readline()
    errors = readline()
    errors1 = readline()
    errors2 = readline()

    ans1 = 0
    for e in errors:
        ans1 ^= e
    
    for e in errors1:
        ans1 ^= e

    print(ans1)

    ans2 = 0
    for e in errors1:
        ans2 ^= e

    for e in errors2:
        ans2 ^= e

    print(ans2)


if __name__ == "__main__":
    main()