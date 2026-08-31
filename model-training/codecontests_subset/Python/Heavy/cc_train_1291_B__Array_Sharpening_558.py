# maa chudaaye duniya
def get1(tmp1, arr):
    for i in range(1, n):
        if arr[i] >= i and tmp1[i-1] == 1:
            tmp1[i] = 1
    return tmp1
for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    tmp1= [0 for i in range(n)]
    tmp2 = [0 for i in range(n)]
    tmp1[0] = 1
    tmp1 = get1(tmp1, arr)
    tmp2[n-1] = 1
    for i in range(n-2, -1, -1):
        l = n-i-1
        if arr[i] >= l and tmp2[i+1] == 1:
            tmp2[i] = 1
    flag = False
    for i in range(n):
        if tmp1[i] == 1 and tmp2[i] == 1:
            flag = True
    # print(tmp1, tmp2)
    if flag:
        print('Yes')
    else:
        print('No')
    