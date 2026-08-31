# Help Vasilisa the Wise 2

import itertools


def calculate(r1, r2, c1, c2, d1, d2):
    combinations = list(itertools.permutations([i for i in range(1,10)], 4))
    for (x1, x2, x3, x4) in combinations:
        r1_sum = x1 + x2
        r2_sum = x3 + x4
        c1_sum = x1 + x3
        c2_sum = x2 + x4
        d1_sum = x1 + x4
        d2_sum = x2 + x3

        if (r1_sum == r1 and r2_sum == r2 and c1_sum == c1 and c2_sum == c2 and d1_sum == d1 and d2_sum == d2):
            print(str(x1) + " " + str(x2))
            print(str(x3) + " " + str(x4))
            return
    print(-1)


if __name__ == "__main__":
    r1, r2 = list(map(lambda x: int(x), input().split()))
    c1, c2 = list(map(lambda x: int(x), input().split()))
    d1, d2 = list(map(lambda x: int(x), input().split()))
    calculate(r1, r2, c1, c2, d1, d2)
