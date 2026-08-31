# from bisect import bisect_left
TC = int(input())

for tc in range(TC):
    N = int(input())
    result = 0

    if N == 1:
        result = 0
    else:
        if N % 3 != 0:
            result = -1
        else:
            while N % 3 == 0:
                N = N // 3
                result += 1

            if N > 2 ** result or 2 ** result % N != 0:
                result = -1
            else:
                N = 2 ** result // N
                while N % 2 == 0:
                    N = N // 2
                    result += 1

                if N > 1:
                    result = -1

    print(result)
    # //6 *2
