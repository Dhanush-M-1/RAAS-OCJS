__author__ = 'Darren'


def solve():
    import sys
    stdin = sys.stdin if True else open('data')

    def alloc(n):
        nonlocal m, id_counter, memory, block_pointer
        space = 0
        for i in range(m):
            if memory[i] == 0:
                space += 1
                if space == n:
                    block_pointer.append(i - n + 1)
                    for j in range(i, i-n, -1):
                        memory[j] = id_counter
                    return True
            else:
                space = 0
        return False

    def erase(id):
        nonlocal t, m, memory, block_pointer
        if id <= 0 or id >= len(block_pointer) or block_pointer[id] < 0:
            return False
        i = block_pointer[id]
        while i < m and memory[i] == id:
            memory[i] = 0
            i += 1
        block_pointer[id] = -1
        return True

    def defragment():
        nonlocal m, memory, block_pointer
        i = 0
        for j in range(m):
            if memory[j] > 0:
                if j > 0 and memory[j] != memory[j-1]:
                    block_pointer[memory[j]] = i
                memory[i] = memory[j]
                i += 1
        while i < m:
            memory[i] = 0
            i += 1


    t, m = map(int, next(stdin).split())
    memory = [0 for i in range(m)]
    block_pointer = [-1]
    id_counter = 1
    for command in stdin:
        command = command.strip()
        if command == 'defragment':
            defragment()
        else:
            part1, part2 = command.split()
            part2 = int(part2)
            if part1 == 'alloc':
                if alloc(part2):
                    print(id_counter)
                    id_counter += 1
                else:
                    print('NULL')
            elif part1 == 'erase':
                if not erase(part2):
                    print('ILLEGAL_ERASE_ARGUMENT')
                else:
                    pass
            else:
                pass


if __name__ == '__main__':
    solve()
