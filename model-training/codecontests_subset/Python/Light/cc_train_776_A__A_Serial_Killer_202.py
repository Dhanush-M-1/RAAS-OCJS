def solve(names, new_names):
    solution = (names | new_names) - (new_names & names)
    return solution


def read_names():
    while True: yield set(input().split())


def print_names(names):
    print(' '.join(names))


def main():
    namesg = read_names()

    names = next(namesg)
    print_names(names)

    n = int(input()) 
    for _ in range(n):
        new_names = next(namesg)
        names = solve(names, new_names)
        print_names(names)


main()
