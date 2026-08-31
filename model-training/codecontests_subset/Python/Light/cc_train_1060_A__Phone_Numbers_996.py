def counter(cards, n):
    if(n<11):
        return 0
    else:
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
    res = counter(cards, n)
    print(res)

stand_input()