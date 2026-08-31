t = int(input())

alph = 'abcdefghijklmnopqrstuvwxyz'

a_symbol_code = 97
for i in range(t):
    n, m = map(int, input().split())
    combo = input()
    ans = {symbol: 0 for symbol in alph}
    tries = sorted([int(correct_num) for correct_num in input().split()])
    tries.append(len(combo))

    multiplier = len(tries)
    cur_letter = iter(combo)
    previous_try_stop = 0

    for current in tries:
        for letter_index in range(current - previous_try_stop):
            ans[next(cur_letter)] += multiplier
        previous_try_stop = current
        multiplier -= 1

    print(*ans.values())



