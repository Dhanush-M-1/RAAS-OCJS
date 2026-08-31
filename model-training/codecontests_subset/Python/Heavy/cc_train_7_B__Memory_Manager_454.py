#!/usr/bin/env python


def main():
    t, m = map(int, input().split())

    nil = 0, 0, 0
    skip = [list(nil) for _ in range(m + 1)]
    skip[0][:] = 0, m, 0

    block = dict()

    free = m
    nth = 0
    for _ in range(t):
        line = input()
        cmd = line[0]
        if cmd == "a":
            size = int(line[6:])
            if size > free:
                print("NULL")
                continue
            base = 0
            while base < m:
                used, span, last = skip[base]
                if not used and span >= size:
                    break
                base += span
            else:
                print("NULL")
                continue
            nth += 1
            print(nth)
            free -= size
            block[nth] = base
            skip[base][:] = nth, size, last
            merge = base + span
            if span != size:
                span -= size
                if skip[merge][0]:
                    skip[base + size][:] = 0, span, size
                else:
                    skip[base + size][:] = 0, span + skip[merge][1], size
                    skip[merge][:] = nil
        elif cmd == "e":
            base = block.pop(int(line[6:]), -1)
            if base < 0:
                print("ILLEGAL_ERASE_ARGUMENT")
                continue
            size = skip[base][1]
            free += size
            merge = base + size
            if not skip[merge][0]:
                size += skip[merge][1]
                skip[merge][:] = nil
            merge = base - skip[base][2]
            if not base or skip[merge][0]:
                skip[base][:2] = 0, size
            else:
                skip[merge][1] += size
                skip[base][:] = nil
        elif block and free:
            base = move = last = 0
            while move < m:
                if skip[move][0]:
                    if move != base:
                        skip[base][:] = skip[move]
                        skip[move][:] = nil
                        block[skip[base][0]] = base
                    skip[base][2] = last
                    last = skip[base][1]
                    base += last
                    move += last
                else:
                    size = skip[move][1]
                    skip[move][:] = nil
                    move += size
            skip[base][:] = 0, free, last


if __name__ == '__main__':
    main()
