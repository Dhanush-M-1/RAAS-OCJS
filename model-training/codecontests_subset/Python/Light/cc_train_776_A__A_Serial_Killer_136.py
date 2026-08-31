def main():
    a = input().split()
    print(*a)
    for i in range(int(input())):
        b, c = input().split()
        a[a.index(b)] = c
        print(*a)


if __name__ == "__main__":
    main()