a ,b = [int(a) for a in input().split()]
res = a
rest = a
while rest >= b:
    tmp = int(rest/b)
    res += tmp
    rest = tmp + rest % b

print(res)