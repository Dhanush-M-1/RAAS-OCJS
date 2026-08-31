if __name__ == '__main__':
    n = int(input())
    a = [int(x) for x in input().split()]
    even = odd = 0

    for i in a:
        if i % 2:
            odd += 1
        else:
            even += 1

    d = even - odd
    if abs(d) <= 1:
        print(0)
        exit()

    balance = d > 0  # True if more evens
    count = abs(d) - 1  # Number of elements not deleted
    stay = []
    for i in a:
        if balance and not i % 2 or not balance and i % 2:
            stay.append(i)

    stay.sort()
    print(sum(stay[:count]))
