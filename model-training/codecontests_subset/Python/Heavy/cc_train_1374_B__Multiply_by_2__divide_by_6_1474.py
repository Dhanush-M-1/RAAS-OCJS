def factorization_by_three(num):
    cnt = 0
    while num % 3 == 0:
        num = num / 3
        cnt = cnt + 1

    return cnt, num


def factorization_by_two(num):
    cnt = 0
    while num % 2 == 0:
        num = num / 2
        cnt = cnt + 1
    x = factorization_by_three(num)
    cnt3 = x[0]
    n = x[1]
    return cnt, cnt3, n


def main():
    test_case = int(input())
    while test_case != 0:
        num = int(input())
        no = factorization_by_two(num)
        cnt2 = no[0]
        cnt3 = no[1]
        n = no[2]
        if n == 1 and cnt2 <= cnt3:
            print((cnt3 - cnt2) + cnt3)
        else:
            print(-1)
        test_case = test_case - 1


if __name__ == '__main__':
    main()
