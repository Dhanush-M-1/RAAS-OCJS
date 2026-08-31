def main():
    n = int(input())
    arr = list(map(int, input().split()))
    odds = []
    evens = []
    for i in range(n):
        if arr[i] % 2:
            odds.append(arr[i])
        else:
            evens.append(arr[i])
    odds = sorted(odds, reverse = True)
    evens = sorted(evens, reverse = True)
    # if (len(odds) - len(evens)) ** 2 <= 1:
    #     print(0)
    #     return 0
    if len(odds) < len(evens):
        print(sum(evens[len(odds) + 1:]))
    else:
        print(sum(odds[len(evens) + 1:]))
    return 0
main()