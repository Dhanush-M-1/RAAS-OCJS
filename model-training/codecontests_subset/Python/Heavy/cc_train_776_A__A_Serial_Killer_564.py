if __name__ == '__main__':
    first, second = input().split()
    initial = [first, second]
    n = int(input())

    i = 0
    victims = []
    while i < n:
        first, last = input().split()
        victims.append([first, last])
        i += 1

    i = 1
    print(initial[0], initial[1])

    if victims[0][0] == initial[0]:
        victims[0][0] = victims[0][1]
        victims[0][1] = initial[1]
    elif victims[0][0] == initial[1]:
        victims[0][0] = initial[0]

    print(victims[0][0], victims[0][1])
    while i < n:
        if victims[i][0] == victims[i - 1][0]:
            victims[i][0] = victims[i][1]
            victims[i][1] = victims[i - 1][1]
        elif victims[i][0] == victims[i - 1][1]:
            victims[i][0] = victims[i - 1][0]

        print(victims[i][0], victims[i][1])
        i += 1
