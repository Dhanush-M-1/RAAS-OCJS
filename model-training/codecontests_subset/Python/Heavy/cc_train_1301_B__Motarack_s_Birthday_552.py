# B. Motarack's Birthday (Div 2)
from math import inf


def main():
    for _ in range(int(input())):
        n = int(input())
        gifts = list(map(int, input().split(" ")))
        checker_list = []
        for i in range(len(gifts)):
            if i == 0:
                if gifts[i] != -1 and gifts[i + 1] == -1:
                    checker_list.append(gifts[i])

            elif i == len(gifts) - 1:
                if gifts[i] != -1 and gifts[i - 1] == -1:
                    checker_list.append(gifts[i])
            else:
                if gifts[i] != -1 and (gifts[i + 1] == -1 or gifts[i - 1] == - 1):
                    checker_list.append(gifts[i])

        if checker_list:
            mn = min(checker_list)
            mx = max(checker_list)

            k = (mx + mn) // 2
            for i in range(len(gifts)):
                if gifts[i] == -1:
                    gifts[i] = k

            diff_list = []
            for i in range(len(gifts) - 1):
                diff_list.append(abs(gifts[i] - gifts[i + 1]))
            max_diff = max(diff_list)
            print(max_diff, k)
        else:
            print(0, 1)


if __name__ == "__main__":
    main()