def solve(l1, l2):
    for i in range(len(l1)):
            if l1[i] in l2:
                return l1[i]

    return -1
    

for _ in range(int(input())):
    n, m = [int(x) for x in input().split()]
    l1 = [int(x) for x in input().split()]
    l2 = [int(x) for x in input().split()]
    l1 = sorted(list(set(l1)))
    l2 = sorted(list(set(l2)))

    if len(l1) > len(l2):
        x = solve(l1, l2)
            
    else:
        x = solve(l2, l1)
    
    if x == -1:
        print('NO')

    else:
        print('YES')
        print(1, x)
