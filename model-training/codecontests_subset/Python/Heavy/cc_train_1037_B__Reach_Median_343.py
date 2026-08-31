[n,s] = map(int, input().split())

input_list = list(map(int, input().split()))

middle = int(n /2 )

input_list = sorted(input_list)
if input_list[middle] == s:
## no need
    print(0)
elif input_list[middle] > s:
    cur = middle
    ret = 0
    while cur >= 0 and input_list[cur] > s:
        ret = ret + input_list[cur] - s
        cur = cur - 1
    print(ret)
elif input_list[middle] < s:
    cur = middle
    ret = 0
    while cur < n and input_list[cur] < s :
        ret = ret + (s - input_list[cur])
        cur = cur + 1
    print(ret)

