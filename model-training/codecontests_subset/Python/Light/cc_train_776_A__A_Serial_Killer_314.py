def solve():
    new_names = next(name_gen)
    solution = (names | new_names) - (new_names & names)
    print_names(solution)
    return solution


def read_names():
    while True: yield set(input().split())


def print_names(names):
    print(' '.join(names))


def main():
    global name_gen, names, n
    name_gen = read_names()

    names = next(name_gen)
    print_names(names)

    n = int(input()) 
    for _ in range(n):
        names = solve()

main()
