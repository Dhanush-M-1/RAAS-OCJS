def main():
    t_n = int(input())
    price_a, price_b = map(int, input().split())
    cal_a = int(input())
    t_c = sorted([int(input()) for _ in range(t_n)], reverse=True)

    cpd_a = cal_a / price_a
    cal_sum = cal_a
    price_sum = price_a
    b_sum = 0
    for i in range(t_n):
        b_sum += t_c[i]
        new_cpd_a = (cal_a + b_sum) / (price_a + (i + 1) * price_b)
        if new_cpd_a > cpd_a:
            cal_sum += t_c[i]
            price_sum += price_b
            cpd_a = new_cpd_a

    print(int(cal_sum / price_sum))


if __name__ == '__main__':
    main()

