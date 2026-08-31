
def main():
    s1, s2 = input().split()
    n = int(input())
    print(s1, s2)

    while n > 0:
        k1, k2 = input().split()
        if k1 == s1:
            s1 = k2
        else:
            s2 = k2
        n -= 1
        print(s1, s2)


if __name__ == '__main__':
    main()
