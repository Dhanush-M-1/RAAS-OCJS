if __name__ == '__main__':
    T = int(input())

    for _ in range(T):
        n = int(input())
        last_a, last_b = 0, 0
        ans = True
        for _ in range(n):
            a, b = [int(x) for x in input().split()]
            # print('debug: ', a, b)
            if ans:
                diff_a = a - last_a
                diff_b = b - last_b
                if diff_a >= diff_b >= 0:
                    last_a = a
                    last_b = b
                    continue
                else:
                    ans = False

        if ans:
            print("YES")
        else:
            print("NO")
