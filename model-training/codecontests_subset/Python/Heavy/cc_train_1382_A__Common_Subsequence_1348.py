def common_elements(list1, list2):
    return [element for element in list1 if element in list2]

t = int(input())
while t>0:
    al, bl = [int(x) for x in input().split()]
    a = [str(int(x)) for x in input().split()]
    b = [str(int(x)) for x in input().split()]
    '''ccc = common_elements(a, b)
    ccc = sorted(ccc, key=len)
    if len(ccc)>0:
        print("YES")
        print(f'{len(ccc[0])} {" ".join(ccc[0])}')
    else: print("NO")'''
    found = False
    for x in a:
        if x in b:
            found = True
            print("YES")
            print(f'1 {x}')
            break
    if not found:print("NO")
    t-=1

