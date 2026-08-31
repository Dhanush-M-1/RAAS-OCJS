from itertools import zip_longest


def next_even(numbers, idx=0):
    for i in range(idx, len(numbers)):
        if numbers[i] % 2 == 0:
            yield i


def next_odd(numbers, idx=0):
    for i in range(idx, len(numbers)):
        if numbers[i] % 2 == 1:
            yield i


def min_remain_sum(numbers):
    numbers = sorted(numbers, reverse=True)
    numlen = len(numbers)
    even_numbers = len([1 for number in numbers if number % 2 == 0])
    odd_numbers = numlen - even_numbers
    if even_numbers > odd_numbers:
        zipper = zip_longest(next_even(numbers), next_odd(numbers), fillvalue=None)
    else:
        zipper = zip_longest(next_odd(numbers), next_even(numbers), fillvalue=None)
    used = [False] * len(numbers)
    for (idx1, idx2) in zipper:
        if idx1 is not None:
            used[idx1] = True
        if idx2 is not None:
            used[idx2] = True
        if idx1 is None or idx2 is None:
            break
    return sum(numbers[idx] for idx, is_used in enumerate(used) if not is_used)


if __name__ == '__main__':
    n = int(input())
    numbers = [int(part) for part in input().split()]
    print(min_remain_sum(numbers))
