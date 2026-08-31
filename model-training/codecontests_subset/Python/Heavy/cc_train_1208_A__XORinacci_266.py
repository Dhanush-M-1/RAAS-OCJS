def to_bi(num):
    lst = []
    while num > 0:
        lst.append(num % 2)
        num //= 2
    return lst


def xor(a1, b1):
    l = max(len(a1), len(b1))
    # print(l)
    ans = []
    for k in range(abs((len(a1) - len(b1)))):
        a1.append(0)
        b1.append(0)
    # print(a1)
    # print(b1)
    for k in range(l):
        # print(a1[i], end = ' ')
        # print(b1[i])
        if a1[k] == b1[k]:
            ans.append(0)
        else:
            ans.append(1)
    return ans


def to_dec(lst):
    ans = 0
    for i in range(len(lst)):
        ans += (2**i) * lst[i]
    return ans


t = int(input())
for i in range(t):
    a, b, n = map(int,input().split())
    if (n+1) % 3 == 0:
        print(to_dec(xor(to_bi(a), to_bi(b))))
    elif (n+1) % 3 == 2:
        print(b)
    else:
        print(a)

# print(xor(to_bi(325), to_bi(265)))
# print(to_bi(898989))
# print(to_bi(233))
# # print(to_bi(5656))
# print(xor(to_bi(5656), to_bi(233)))
# print(to_dec(xor(to_bi(5656), to_bi(233))))


