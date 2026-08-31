t = int(input())

a_symbol_code = 97
for i in range(t):
    n, m = map(int, input().split())
    combo = input()
    ans = [0 for symbol in range(26)]
    tries = sorted([int(correct_num) for correct_num in input().split()])
    tries.append(len(combo))

    multiplier = len(tries)
    previous_try_stop = 0

    for current in tries:
        for letter_index in range(previous_try_stop, current):
            ans[ord(combo[letter_index]) - a_symbol_code] += multiplier
        previous_try_stop = current
        multiplier -= 1

    print(*ans)



