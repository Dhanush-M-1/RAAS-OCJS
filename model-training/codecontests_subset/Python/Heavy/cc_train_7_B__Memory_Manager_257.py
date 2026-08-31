def mem_alloc(n, a, mem):
    first, last = 0, 0
    free_list= []
    counting = False
    for i in range(len(mem)):
        if counting:
            if mem[i] != 0:
                last = i - 1
                free_list.append((first, last))
                counting = False
            else:
                last = i
        elif mem[i] == 0:
            first = i
            last = i
            counting = True
    if counting:
        free_list.append((first, last))
    for block in free_list:
        if n <= (block[1] - block[0] + 1):
            for j in range(block[0], block[0] + n):
                mem[j] = a
            return True
    return False

def mem_erase(x, mem):
    erased = 0
    for i in range(len(mem)):
        if mem[i] == x:
            mem[i] = 0
            erased = 1
    if erased == 0 or x == 0:
        print("ILLEGAL_ERASE_ARGUMENT")

def mem_defragment(mem):
    i, erased = 0, 0
    while i < len(mem):
        if mem[i] == 0:
            del mem[i]
            erased += 1
        else:
            i += 1
    mem.extend([0] * erased)

t, m = [int(i) for i in input().split()]
memory = [0] * m
alloc_index = 1

while t > 0:
    command = str(input())
    if "alloc" in command:
        n_i = int(command.split()[1])
        if mem_alloc(n_i, alloc_index, memory):
            print(alloc_index)
            alloc_index += 1
        else:
            print("NULL")
    elif "erase" in command:
        x_i = int(command.split()[1])
        mem_erase(x_i, memory)
    else:
        mem_defragment(memory)
    t -= 1
