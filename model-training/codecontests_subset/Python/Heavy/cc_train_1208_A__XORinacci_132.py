input_list = list(map(int, input().split()))

for t in range(0, input_list[0]):
    case = list(map(int, input().split()))
    a = case[0]
    b = case[1]
    n = case[2]
    if n == 0:
        print(a)
    elif n == 1:
        print(b)
    elif a == b:
        if (n+1) % 3 == 0:
            print(0)
        else:
            print(a)
    else:
        res=0
        loop_size = 0
        sdic = [a, b]
        for i in range(2, n+1):
            res = a ^ b
            if res == case[1] and b == case[0]:
                loop_size = i - 1
                break
            a = b
            b = res
            sdic.append(res)
        if loop_size == 0:
            print(sdic[n])
        else:
            print(sdic[n % loop_size])
