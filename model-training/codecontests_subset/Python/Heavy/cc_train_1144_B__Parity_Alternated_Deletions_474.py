def parity(arr):
    odds = []
    evens = []
    for i in arr:
        if i%2 == 0:
            evens.append(i)
        else:
            odds.append(i)
    odds.sort()
    evens.sort()
    sum = 0
    if len(evens) > len(odds) + 1:
        for i in range(len(evens) - len(odds) - 1):
            sum = sum + evens[i]
    elif len(evens) + 1 < len(odds):
        for i in range(len(odds) - len(evens) - 1):
            sum = sum + odds[i]
    return sum

n = input()
arr = list(map(int, input().split()))
print(parity(arr))