# alloc n - allocates n bytes and return x as identifier of the block
# erase x - erases block w/ identifier x
# defragment - moves all block to left
# n - operations
# m - avaible size
n, m = map(int, input().split())
# avaible bytes marked as True
mem = [True] * m
blocks = []
bl_count = 1

for i in range(n):
    temp = input()

    # alloc first block of free mem and print the number of the block, else: NULL
    if temp[0] == 'a':
        bts = int(temp[6:])
        count = 0
        for ii in range(m):
            if mem[ii]:
                count += 1
                if count == bts:
                    break
            else:
                count = 0
        if count == bts:
            for iii in range(bts):
                mem[ii - bts + 1 + iii] = False
            blocks.append([bl_count, ii - bts + 1, bts])
            print(bl_count)
            bl_count += 1
        else:
            print('NULL')

    # erase block x, else ILLEGAL_ERASE_ARGUMENT; doesnt affect next block count
    elif temp[0] == 'e':
        if blocks:
            x = int(temp[6:])
            count = 0
            ii = [0, 0, 0]
            for ii in blocks:
                if ii[0] == x:
                    break
                count += 1

            if ii[0] != x:
                print('ILLEGAL_ERASE_ARGUMENT')
            elif ii[0] == x:
                for iii in range(ii[1], ii[1] + ii[2]):
                    mem[iii] = True
                blocks.pop(count)
        else:
            print('ILLEGAL_ERASE_ARGUMENT')

    # defragment as described above, doesnt print anything
    else:
        foo = mem.count(False)
        bar = m - foo
        mem = [False] * foo
        for i in range(bar):
            mem.append(True)

        blocks.sort(key=lambda z: z[1])
        last = 0
        for i in range(len(blocks)):
            blocks[i][1] = last
            last = blocks[i][1] + blocks[i][2]