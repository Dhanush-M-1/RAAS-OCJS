__author__ = 'Darren'


def solve():
    import sys
    stdin = sys.stdin if True else open('data')

    system = set()
    traffic = 0
    for command in stdin:
        command = command.strip()
        if command[0] == '+':
            system.add(command[1:])
        elif command[0] == '-':
            system.remove(command[1:])
        else:
            name, message = command.split(':')
            traffic += len(system) * len(message)

    print(traffic)


if __name__ == '__main__':
    solve()