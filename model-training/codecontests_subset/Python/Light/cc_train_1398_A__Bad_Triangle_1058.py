def main(case):
    n = int(input())
    lst = list(map(int, input().split()))
    if lst[0] + lst[1] <= lst[-1]:
        print(1, 2, n)
        return
    print(-1)


if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        main(i + 1)
