n = int(input().strip())
x = [int(tmp) for tmp in input().strip().split(' ')]
y = [int(tmp) for tmp in input().strip().split(' ')]

def solve(x, y):
    if x[0] != y[0] or x[-1] != y[-1]:
        return False
    cha_dict = {}
    for i in range(n - 1):
        cha =  x[i + 1] - x[i]
        if cha not in cha_dict:
            cha_dict[cha] = []
        cha_dict[cha].append(i)

    fu_set = set()
    zheng_set = set([0])
    for i in range(n - 1):
        cha = y[i + 1] - y[i]
        is_ok = False
        if cha not in cha_dict:
            return False
        for j in cha_dict[cha]:
            #print(i, j, cha_dict[cha], fu_set, zheng_set)
            if j in fu_set or (j + 1) in zheng_set:
                continue
            is_ok = True
            if j in zheng_set:
                zheng_set.remove(j)
            else:
                fu_set.add(j)
            if (j + 1) in fu_set:
                fu_set.remove(j + 1)
            else:
                zheng_set.add(j + 1)
            break
        if not is_ok:
            #print(i)
            return False
    return True

if solve(x, y):
    print('Yes')
else:
    print('No')
		 		 		 				 																	