def main():
    n, k = map(int, input().split())
    a = map(int, input().split())
    r = max(i for i in a if k % i == 0)
    print(k // r)


if __name__ == '__main__':
    main()
