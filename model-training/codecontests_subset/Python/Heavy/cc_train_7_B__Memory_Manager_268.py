t, m = map(int, input().split())
mem = [0] * m
files = {}
n = 0
for _ in range(t):
    cmd = input()
    if cmd == "defragment":
        i = 0
        while i < m:
            if mem[i] != 0:
                j = i
                while j > 0 and mem[j - 1] == 0:
                    j -= 1
                size = files[mem[i]][1]
                if j < i:
                    files[mem[i]][0] = j
                    mem[j: j + size] = [mem[i]] * size
                    mem[j + size: i + size] = [0] * (i - j)
                i += size
            else:
                i += 1
    else:
        cmd, val = cmd.split()
        val = int(val)
        if cmd == "alloc":
            free = 0
            for i in range(m):
                if not mem[i]:
                    free += 1
                else:
                    free = 0
                if free == val:
                    n += 1
                    print(n)
                    files[n] = [i - val + 1, val]
                    for j in range(i - val + 1, i + 1):
                        mem[j] = n
                    break
            else:
                print("NULL")
        else:
            if val in files:
                for j in range(files[val][0], files[val][0] + files[val][1]):
                    mem[j] = 0
                del files[val]
            else:
                print("ILLEGAL_ERASE_ARGUMENT")
    #print(mem, files)
