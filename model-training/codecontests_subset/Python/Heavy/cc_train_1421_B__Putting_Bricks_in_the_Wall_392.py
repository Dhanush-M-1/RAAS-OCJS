test_count = int(input())

tests = []
for _ in range(test_count):
    x = int(input())
    y = []
    for _ in range(x):
        y.append(list(input()))
    tests.append((x, y))

for test in tests:
    size, grid = test

    start_right = int(grid[0][1])
    start_down = int(grid[1][0])

    end_up = int(grid[size - 2][size - 1])
    end_left = int(grid[size - 1][size - 2])

    x = (start_right, start_down, end_up, end_left)

    if x == (0, 0, 0, 0):
        print(2)
        print(size - 1, size)
        print(size, size - 1)
    elif x == (0, 0, 0, 1):
        print(1)
        print(size - 1, size)
    elif x == (0, 0, 1, 0):
        print(1)
        print(size, size - 1)
    elif x == (0, 0, 1, 1):
        print(0)
    elif x == (0, 1, 0, 0):
        print(1)
        print(1, 2)
    elif x == (0, 1, 0, 1):
        print(2)
        print(1, 2)
        print(size, size - 1)
    elif x == (0, 1, 1, 0):
        print(2)
        print(1, 2)
        print(size - 1, size)
    elif x == (0, 1, 1, 1):
        print(1)
        print(2, 1)
    elif x == (1, 0, 0, 0):
        print(1)
        print(2, 1)
    elif x == (1, 0, 0, 1):
        print(2)
        print(1, 2)
        print(size - 1, size)
    elif x == (1, 0, 1, 0):
        print(2)
        print(1, 2)
        print(size, size - 1)
    elif x == (1, 0, 1, 1):
        print(1)
        print(1, 2)
    elif x == (1, 1, 0, 0):
        print(0)
    elif x == (1, 1, 0, 1):
        print(1)
        print(size, size - 1)
    elif x == (1, 1, 1, 0):
        print(1)
        print(size - 1, size)
    elif x == (1, 1, 1, 1):
        print(2)
        print(size - 1, size)
        print(size, size - 1)