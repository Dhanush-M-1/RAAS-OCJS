def main():
    t = int(input())
    for turn in range(1, t + 1):
        n = int(input())
        stats = []
        last_p = 0
        last_c = 0
        prop = True
        for nth in range(1, n+1):
            x = input().split(' ')
            x[0] = int(x[0])
            x[1] = int(x[1])
            stats.append(x)
            if x[0] < last_p or x[1] < last_c:
                prop = False
            if x[0] < x[1]:
                prop = False
            if x[1] - last_c > x[0]- last_p:
                prop = False
            last_p = x[0]
            last_c = x[1]

        if prop:
            print('YES')
        else:
            print('NO')


if __name__ == '__main__':
    main()
