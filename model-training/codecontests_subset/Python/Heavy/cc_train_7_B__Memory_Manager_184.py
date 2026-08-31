t, m = map(int, input().split())
mem = [True] * m
where = []
lens = []
for i in range(t):
    cmd = input()
    if cmd[0] == 'a':
        cmd, n = cmd.split()
        n = int(n)
        for st in range(m - n + 1):
            if all(mem[st : st + n]):
                x = len(where)
                where.append(st)
                lens.append(n)
                mem[where[x] : where[x] + lens[x]] = [False] * lens[x]
                print(x + 1)
                break
        else:
            print('NULL')
    elif cmd[0] == 'e':
        cmd, x = cmd.split()
        x = int(x) - 1
        if x < 0 or x >= len(where) or where[x] == -1:
            print('ILLEGAL_ERASE_ARGUMENT')
        else:
            mem[where[x] : where[x] + lens[x]] = [True] * lens[x]
            where[x] = -1
    else:
        for j in range(1, m):
            if not mem[j] and mem[j - 1]:
                x = where.index(j)
                st = j - 1
                while st > 0 and mem[st - 1]:
                    st -= 1
                mem[where[x] : where[x] + lens[x]] = [True] * lens[x]
                where[x] = st
                mem[where[x] : where[x] + lens[x]] = [False] * lens[x]
