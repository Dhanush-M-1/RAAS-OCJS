t = int(input())
for ti in range(t):
    n = int(input())
    li = [int(i) for i in input().split(' ')]
    ss = 0
    cc = 0
    sep = 0
    _min = 1919810114514
    _max = 0
    for idx, i in enumerate(li):

        if i == -1:
            if idx and li[idx-1] != -1:
                _min = min(_min, li[idx-1])
                _max = max(_max, li[idx-1])

        else:
            
            if idx and li[idx-1] != -1:
                sep = max(sep, abs(li[idx-1]-i))
            elif idx and li[idx-1] == -1:
                _min = min(_min, i)
                _max = max(_max, i)
            ss += i
            cc += 1
    if cc:
        #r = round(ss/cc)
        r = (_min+_max)//2
        sep = max(sep,r - _min, _max-r)
        print(sep,r)
    else:
        print(0,0)