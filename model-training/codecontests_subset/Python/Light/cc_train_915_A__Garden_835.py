def main():
    n, k = map(int, input().split())

    l_h = 1000
    a = list(map(int, input().split()))

    for ai in a:
        if k%ai == 0 and k/ai < l_h:
            l_h = k/ai

    print(int(l_h))


if __name__ == '__main__':
    main()