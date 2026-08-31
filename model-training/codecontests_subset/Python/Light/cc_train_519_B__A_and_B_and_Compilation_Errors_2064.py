n = int(input())
lst = [int(i) for i in input().split()]
lst.sort()
for i in range(2):
    new_lst = [int(i) for i in input().split()]
    new_lst.sort()
    #print(new_lst)
    #print(lst)
    fl = True
    for i in range(len(new_lst)):
        if new_lst[i] != lst[i]:
            print(lst[i])
            fl = False
            break
    if fl:
        print(lst[-1])
    lst = new_lst.copy()