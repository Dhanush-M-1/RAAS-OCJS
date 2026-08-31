for _ in range(int(input())):
    n = int(input())
    s = input()
    # temp_res = 1
    # arr = []
    # symbols = []
    # last = s[0]
    # for c in s[1:]:
    #     if c != last:
    #         arr.append(temp_res)
    #         symbols.append(last)
    #         temp_res = 1
    #     last = c
    #     temp_res += 1
    # arr.append(temp_res - 1)
    # symbols.append(last)
    # # print(arr)
    # # print(symbols)
    # total = 0
    # last_symbol = symbols[0]
    # last_res = arr[0]
    # for res, symbol in zip(arr, symbols):
    #     if last_symbol == "<" and symbol == ">":
    #         total += min(last_res, res)
    #     last_res = res
    #     last_symbol = symbol
    # print(total)
    s1 = 0
    s2 = 0
    for i in s:
        if i == "<":
            s1 += 1
        else:
            break
    for i in s[::-1]:
        if i == ">":
            s2 += 1
        else:
            break
    print(min(s1, s2))