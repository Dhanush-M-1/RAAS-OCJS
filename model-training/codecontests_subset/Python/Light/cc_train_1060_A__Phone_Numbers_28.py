def find_number(cards, n):
    if n < 11:
        return 0
    max_by_len = n // 11
    count_of_eight = 0
    for c in cards:
        if c == '8':
            count_of_eight += 1
            if count_of_eight >= max_by_len:
                break
    return count_of_eight

def stand_input():
    n = int(input())
    cards = input()
    count_of_nums = find_number(cards, n)
    print(count_of_nums)

stand_input()