def solve():
    n = int(input())
    arr = list(input())

    index = 0

    while index < n:
        letter = arr[index]

        if letter in ['a', 'e', 'i', 'o', 'u', 'y']:
            current = index + 1

            while current < n and arr[current] == letter:
                current += 1

            if current - index == 2 and (letter == 'e' or letter == 'o'):
                print("{}{}".format(letter, letter), end="")

            else:
                print(letter, end="")
            index = current

        else:
            print(letter, end="")
            index += 1
    print()

solve()
