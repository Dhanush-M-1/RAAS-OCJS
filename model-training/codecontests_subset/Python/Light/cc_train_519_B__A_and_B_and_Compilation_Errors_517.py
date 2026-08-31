if __name__ == '__main__':
    n = int(input())
    errs1 = input().split(" ")
    errs2 = input().split(" ")
    errs3 = input().split(" ")

    errs1 = sorted([int(_) for _ in errs1])[::-1]
    errs2 = sorted([int(_) for _ in errs2])[::-1]
    errs3 = sorted([int(_) for _ in errs3])[::-1]

    errs2 += [0]
    errs3 += [0, 0]

    found_err1 = 0
    found_err2 = 0
    for err1, err2, err3 in zip(errs1, errs2, errs3):
        if err1 != err2 and found_err1 == 0:
            found_err1 = err1
        if err2 != err3 and found_err2 == 0:
            found_err2 = err2

    print(found_err1)
    print(found_err2)
