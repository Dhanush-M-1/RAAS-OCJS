import copy
n = int(input())
num = list(map(int, list(input())))
if n == 1:
    print(1)
    print(num[0])
else:
    #print(num)
    kee = list()
    for i in range(n):
        kee.append(list())
        tmp = list()
        zero = 0
        one = 0
        for j in range(i, n):
            tmp.append(num[j])
            if num[j] == 0:
                zero += 1
            else:
                one += 1
            if zero != one:
                kee[i].append(copy.deepcopy(tmp))
    stk = list()
    #print(kee)
    for i in range(len(kee[0])):
        stk.append([1, [[0, i]], len(kee[0][i])])
    res = list()
    mindepth = 987654321
    while True:
        if len(stk) == 0:
            break
        pick = stk.pop()
        depth = pick[0]
        curr = copy.deepcopy(pick[1])
        #print(curr)
        size = pick[2]
        if size == n:
            if mindepth > depth:
                res = curr
                mindepth = depth
        if depth < mindepth and size < n:
            for i in range(len(kee[size])):
                if size + len(kee[size][i]) < n:
                    stk.append([depth+1, curr + [[size, i]], size+len(kee[size][i])])
                elif size + len(kee[size][i]) == n:
                    if mindepth > depth:  
                        res = curr + [[size, i]]
                        mindepth = depth+1

    print(mindepth)
    #print(res)
    for itm in res:
        #print(itm)
        for ch in kee[itm[0]][itm[1]]:
            print(ch, end="")
        print(end=" ")