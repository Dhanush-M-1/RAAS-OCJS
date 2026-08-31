def main():
    scan = input
    integer = int
    array = list
    loop = map
    test_case = integer(scan())
    answer = []

    for i in range(test_case):
        result = 0
        stones = array(loop(integer, scan().split()))
        if stones[1] >= 1 and stones[2] >= 2:
            while True:
                result += 3
                stones[1] -= 1
                stones[2] -= 2
                if stones[1] == 0 or stones[2] <= 1:
                    break
        if stones[0] >= 1 and stones[1] >= 2:
            while True:
                result += 3
                stones[0] -= 1
                stones[1] -= 2
                if stones[0] == 0 or stones[1] <= 1:
                    break
        answer.append(result)
    for i in answer:
        print(i)


main()
