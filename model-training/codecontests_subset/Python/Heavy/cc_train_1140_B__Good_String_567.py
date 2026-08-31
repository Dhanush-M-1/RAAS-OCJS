LESS = '<'
MORE = '>'

def make_good_string():
    n = int(input())
    s = input()

    left_less = 0
    right_more = 0

    for i in range(n):
        if s[i] == MORE:
            break
        left_less += 1

    for i in reversed(range(n)):
        if s[i] == LESS:
            break
        right_more += 1

    if not left_less or not right_more:
        return 0

    return left_less if left_less < right_more else right_more


def main():
    tests_count = int(input())

    for i in range(tests_count):
        print(make_good_string())


if __name__ == '__main__':
    main()