def get_frequency(numbers):
    frequency = {}
    for number in numbers:
        if number not in frequency:
            frequency[number] = 0
        frequency[number] += 1
    return frequency


def find_missing(original, changed):
    original_freq = get_frequency(original)
    changed_freq = get_frequency(changed)
    for number in original_freq:
        if number not in changed_freq:
            return number
        elif original_freq[number] != changed_freq[number]:
            return number


def main():
    n = int(input())
    first_line = [int(token) for token in input().split()]
    second_line = [int(token) for token in input().split()]
    third_line = [int(token) for token in input().split()]

    first_error = find_missing(first_line, second_line)
    second_error = find_missing(second_line, third_line)

    print(first_error)
    print(second_error)


if __name__ == '__main__':
    main()