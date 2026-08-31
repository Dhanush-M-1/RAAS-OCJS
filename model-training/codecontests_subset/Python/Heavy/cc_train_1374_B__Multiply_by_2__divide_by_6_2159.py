def read_int() -> int:
    return int(input())


def read_ints():
    return map(int, input().split(' '))


def test_case():
    original_number = read_int()
    number = original_number
    steps = 0
    while number != 1:
        if number % 6 == 0:
            number /= 6
            steps += 1
        else:
            number *= 2
            steps += 1
            if number > 2 * original_number:
                print(-1)
                return -1
    else:
        print(steps)

if __name__ == '__main__':
    tests = read_int()
    for _ in range(tests):
        test_case()
