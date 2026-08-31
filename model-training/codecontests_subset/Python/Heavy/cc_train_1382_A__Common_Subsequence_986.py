T = int(input())
for rounds in range(T):
    n = list(map(int, input().split()))
    a1 = list(map(int, input().split()))
    a2 = list(map(int, input().split()))
    cnt_arr1 = [0 for i in range(1001)]
    cnt_arr2 = [0 for i in range(1001)]
    cnt_arr = [0 for i in range(1001)]
    for i in range(n[0]):
        cnt_arr1[a1[i]] =1
    for i in range(n[1]):
        cnt_arr2[a2[i]] =1
    cnt_arr = [cnt_arr1[i]+cnt_arr2[i] for i in range(1001)]
    k = 9999
    idx = -1
    for i in range(1001):
        if cnt_arr[i]<=k and cnt_arr[i]>1:
            k = cnt_arr[i]
            idx = i
    if idx !=-1:
        print('YES')
        print(k-1, idx)
    else:
        print('NO')