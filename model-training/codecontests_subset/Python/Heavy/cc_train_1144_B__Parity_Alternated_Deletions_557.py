_ = input()
inp_list = list(map(int, input().split()))

def solve(list_):
    odds = []
    evens = []
    for num in list_:
        if num % 2 == 0:
            evens.append(num)
        else:
            odds.append(num)
    if abs(len(odds) - len(evens)) <= 1:
        return 0
    is_odd_deletion = len(odds) > len(evens)
    if is_odd_deletion:
        odds = sorted(odds, reverse=True)
        res = sum(odds[len(evens)+1:])
    else:
        evens = sorted(evens, reverse=True)
        res = sum(evens[len(odds)+1:])
    return res

res = solve(inp_list)
print(res)
