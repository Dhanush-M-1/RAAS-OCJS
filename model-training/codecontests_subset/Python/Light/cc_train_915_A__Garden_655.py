a, b = [int(i) for i in input().split()]
dig = [int(i) for i in input().split()]
res = b +1
for i in range(len(dig)):
    if b % dig[i] == 0 and b // dig[i] < res:
        res = b // dig[i]
print(res)