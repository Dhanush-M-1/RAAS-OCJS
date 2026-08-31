from bisect import bisect_left

tc = int(input())

for _ in range(tc):
    n, m = list(map(int, input().split()))
    a = list(map(int, input().split()))
    x = list(map(int, input().split()))
    Val = sum(a)
    process = []
    ret = []
    curr = 0
    index = {}
    for i in range(n):
        curr += a[i]
        if i == 0:
            process.append(curr)
            index[curr] = i
        elif curr > process[-1]:
            process.append(curr)
            index[curr] = i            
    localBig = process[-1]
    for num in x:
        if localBig < num and Val <= 0:
            ret.append('-1')
            continue
        spins = 0
        if localBig < num:
            spins = (num-localBig+Val-1)//Val
        num -= spins * Val
        pos = spins * n + index[process[bisect_left(process, num)]]
        ret.append(str(pos))
    print(' '.join(ret))
        

    