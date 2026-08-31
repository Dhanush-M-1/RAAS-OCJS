def input_numbers():
    return list(map(int, input().split()))

if __name__ == '__main__':
    n = int(input())
    a, b, c = input_numbers(), input_numbers(), input_numbers()

    a, b, c = sorted(a), sorted(b), sorted(c)

    first_found = False
    first = None

    for i in range(n - 1):
        if a[i] == b[i]:
            continue
        first_found = True
        first = a[i]
        break
    
    if not first_found:
        first = a[-1]

    second = None
    second_found = False
    for i in range(n - 2):
        if b[i] == c[i]:
            continue
        second_found = True
        second = b[i]
        break

    if not second_found:
        second = b[-1]
    
    print(first)
    print(second)
            