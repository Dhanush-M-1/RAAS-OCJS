#!/usr/bin/env python


def main():
    t, m = map(int, input().split())

    block = list()
    alloc = block.append
    alloc([0, 0])
    usage = [0] * m
    m_range = range(m)

    free = m
    for _ in range(t):
        line = input()
        cmd = line[0]
        if cmd == "a":
            size = int(line[6:])
            if size > free:
                print("NULL")
                continue
            span = 1
            for addr in m_range:
                if usage[addr]:
                    span = 1
                elif span != size:
                    span += 1
                else:
                    break
            else:
                print("NULL")
                continue
            print(len(block))
            head = addr - size + 1
            alloc([1, head, size])
            usage[head:addr + 1] = (1,) * size
            free -= size
        elif cmd == "e":
            n = int(line[6:])
            if 0 < n < len(block) and block[n][0]:
                block[n][0] = 0
                _, head, size = block[n]
                usage[head:head + size] = (0,) * size
                free += size
            else:
                print("ILLEGAL_ERASE_ARGUMENT")
        elif 0 < free < m:
            for chunk in block:
                if not chunk[0]:
                    continue
                head = chunk[1]
                chunk[1] -= head - sum(usage[addr] for addr in range(head))
            used = m - free
            usage[:used] = (1,) * used
            usage[used:] = (0,) * free


if __name__ == '__main__':
    main()
