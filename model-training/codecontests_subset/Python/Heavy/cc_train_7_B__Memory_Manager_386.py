t, n = map(int, input().split())

id = 1
arr = []
for i in range(0, t):
    s = input()
    if s == 'defragment':
        idx = 0
        prev = 0
        while idx < len(arr):
            if arr[idx][0] == -1000:
                arr.pop(idx)
            else:
                size = arr[idx][2] - arr[idx][1]
                arr[idx] = [arr[idx][0], prev, prev + size]
                prev = prev + size
                idx += 1
        # print(arr)
            # print(idx)
    else:
        op = s.split()[0]
        val = int(s.split()[1])
        if op == 'alloc':
            start = 0
            idx = 0
            while idx < len(arr):
                next = arr[idx]
                if next[1] == -1000:
                    idx += 1
                elif next[1] - start >= val:
                    break
                else:
                    start = next[2]
                    idx += 1
            if n - start >= val:
                arr.insert(idx, [id, start, start + val])
                print(id)
                # print(arr[idx])
                id += 1
            else:
                print('NULL')
        else:
            isIllegal = False
            # print('earse', val)
            for rg in arr:
                if rg[0] == val:
                    rg[0] = rg[1] = rg[2] = -1000
                    isIllegal = True
                    break
            if not isIllegal:
                print('ILLEGAL_ERASE_ARGUMENT')

