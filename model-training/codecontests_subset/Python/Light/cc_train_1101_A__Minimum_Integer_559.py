def main():
    q = int(input())
    for _ in range(q):
        [l, r, d] = [int(x) for x in input().split()]
        if l <= d <= r:
            print((r // d + 1) * d)
        else:
            print(d)

if __name__ == '__main__':
    main()