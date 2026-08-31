for _ in range(int(input())):
    n = int(input())
    array = list(map(int, input().split()))
    k = None
    flag1 = 1
    ans = [None]*n
    this = 0
    for i in range(n):
        if array[i] >= i:
            ans[i] = i
        else:
            ans[i-1] = array[i-1]
            k = i-1
            flag1 = 0
            break

    if k == None:
        print('Yes')
        continue
    flag2 = 1
    for i in range(k, n):
        if array[i] >= n-i-1:
            ans[i] = array[i]
        else:
            flag2 = 0
            break

    if flag1 == 1:
        if flag2 == 1 and ans.count(None)==0:
            print('Yes')
        else:
            print('No')
    else:
        if flag2 == 1 and ans.count(None)==0:
            print('Yes')
        else:
            print('No')