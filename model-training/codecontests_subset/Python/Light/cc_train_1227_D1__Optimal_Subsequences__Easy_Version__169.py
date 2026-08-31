n = int(input())
arr = list(map(int, input().split()))
arr_sorted = [(arr[i], i) for i in range(n)]
arr_sorted.sort(key = lambda el: (el[0], -el[1]), reverse = True)
m = int(input())
for req_i in range(m):
    k, pos = map(int, input().split())
    pos -= 1
    cur_arr = arr_sorted[:k]
    cur_arr.sort(key = lambda el: el[1])
    print(cur_arr[pos][0])