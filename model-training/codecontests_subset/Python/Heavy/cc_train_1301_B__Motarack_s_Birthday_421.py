import string


def main():
    n = int(input())
    lst = list(map(int, input().split()))
    maxdif = 0
    mindif = 9999999999999
    amm = 0
    if lst[0] == -1 and lst[1] != -1:
        amm += 1
        maxdif = max(maxdif, lst[1])
        mindif = min(mindif, lst[1])
    if lst[-1] == -1 and lst[-2] != -1:

        amm += 1
        maxdif = max(maxdif, lst[-2])
        mindif = min(mindif, lst[-2])
    for i in range(1, n - 1):
        if lst[i] == -1:
            if lst[i - 1] != -1:
                amm += 1
                maxdif = max(maxdif, lst[i - 1])
                mindif = min(mindif, lst[i - 1])
            if lst[i + 1] != -1:
                amm += 1
                maxdif = max(maxdif, lst[i + 1])
                mindif = min(mindif, lst[i + 1])
    num = (maxdif + mindif) // 2
    if amm == 0:
        print(0, 47)
        return
    m = 0
    for i in range(0, n):
        if lst[i] == -1:
            lst[i] = num

    for i in range(0, n - 1):
        m = max(m, abs(lst[i] - lst[i + 1]))
    print(m, num)


if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        main()
