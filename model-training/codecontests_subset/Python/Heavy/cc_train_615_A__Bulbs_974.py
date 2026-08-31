def check_bulbs(m, n, buttons):
    checker = [0] * m

    for i in range(n):
        bulbs = buttons[i]
        for x in bulbs:
            if 0 < x <= m:
                checker[x-1] += 1

    for c in checker:
        if c == 0:
            return "NO"

    return "YES"

if __name__ == "__main__":
    n, m = input().split()
    n, m = int(n), int(m)
    buttons = [None] * n
    for i in range(n):
        current = input().split()
        current = [int(x) for x in current]
        buttons[i] = current[1:]

    result = check_bulbs(m, n, buttons)
    print(result)
