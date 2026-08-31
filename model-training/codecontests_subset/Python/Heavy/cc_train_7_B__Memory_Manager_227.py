
t, m = map(int, input().split())
ops = []
m = [0]*m
blocks = dict()
for i in range(t):
    op = list(input().split())
    if len(op) > 1:
        nr = int(op[1])
        ops.append([op[0], nr])
    else:
        ops.append([op[0]])


def alloc(indf ,size):
    global m, blocks
    c = 0
    for i in range(len(m)):
        if m[i] == 0:
            c += 1
            if c == 1:
                str_idx = i
        if m[i] == 1:
            c = 0
        if c == size:
            end_idx = i
            for i in range(str_idx, end_idx+1):
                m[i] = 1
            blocks[indf] = [str_idx, end_idx+1]
            return True
    return False

def erase(indf):
    global m, blocks, ops_idx_alloc
    for indetificators , indexes in blocks.items():
        if indetificators == indf:
            for i in range(indexes[0], indexes[1]):
                m[i] = 0
            del blocks[indf]
            return True
    return False

def defragment():
    global m , blocks
    end_block = 0
    for idf, idx in blocks.items():
        size_realloc = idx[1] - idx[0]
        for i in range(idx[0], idx[1]):
            m[i] = 0
        alloc(idf, size_realloc)

ops_idx_alloc = [0]
a = 0
alloc_list = [0]
for i in range(len(ops)):

    if ops[i][0] == 'alloc':
        idnnf = max(alloc_list)+1

        if alloc(idnnf , ops[i][1]):
            print( idnnf)
            alloc_list.append(idnnf)
        else:
            print('NULL')
            if a != 1:
                a += 1


    elif ops[i][0] == 'erase':
        if erase(ops[i][1]) == False:
            print('ILLEGAL_ERASE_ARGUMENT')
        #else:
            #a -= 1
    elif ops[i][0] == 'defragment':
        defragment()
