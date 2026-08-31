testcases = int(input())
while testcases != 0:
    x = int(input())

    two_count, three_count = 0, 0
    while x % 2 == 0:
        x = x/2
        two_count = two_count + 1
    while x % 3 == 0:
        x = x/3
        three_count = three_count + 1
    if two_count <= three_count and x == 1:

        divide_by_sixx_moves = min(two_count, three_count)
        two_count = two_count - divide_by_sixx_moves
        three_count = three_count - divide_by_sixx_moves

        if two_count == three_count:
            print(divide_by_sixx_moves)
        else:
            print(divide_by_sixx_moves + (three_count - two_count)*2)
    else:
        print(-1)

    testcases = testcases - 1
