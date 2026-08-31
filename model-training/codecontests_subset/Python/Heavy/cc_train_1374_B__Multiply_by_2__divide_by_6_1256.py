def make_one(n):
    if n == 1:
        return 0
    pow_of_two = 0
    temp = n
    while not temp % 2:
        temp //= 2
        pow_of_two += 1
    
    pow_of_three = 0
    while not temp % 3:
        temp //= 3
        pow_of_three += 1
    
    if temp != 1: return -1

    if pow_of_two > pow_of_three: return -1
    else:
        return 2 * pow_of_three - pow_of_two


if __name__ == "__main__":
    test_cases = int(input())

    while test_cases:

        print(make_one(int(input())))

        test_cases -= 1