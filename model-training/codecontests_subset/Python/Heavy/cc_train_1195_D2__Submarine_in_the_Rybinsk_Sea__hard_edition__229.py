mod = 998244353
ten = [1]
for i in range(1, 30):
    ten.append(ten[i - 1] * 10 % mod)


def funcxy(bit, x_l, y_l):
    if x_l >= y_l:
        if y_l > bit:
            return ten[2 * bit + 1]
        else:
            return ten[bit + y_l]
    else:
        return ten[2 * bit + 1]


def funcyx(bit, x_l, y_l):
    if x_l > y_l:
        if y_l > bit:
            return ten[2 * bit]
        else:
            return ten[bit + y_l]
    else:
        return ten[2 * bit]



n = int(input())
a = [x for x in input().split()]
length = [len(x) for x in a]
d = {}

for x in length:
    if x in d:
        d[x] += 1
    else:
        d[x] = 1

len_set = set(length)
res = 0
for x in a:
    x_l = len(x)
    x = [int(x_) for x_ in x[::-1]]
    for i, xi in enumerate(x):
        for y_l in len_set:
            res += xi * funcxy(i, x_l, y_l) * d[y_l]
            res += xi * funcyx(i, x_l, y_l) * d[y_l]
print(res % mod)


'''
if __name__ == "__main__":
    print(funcxy(4, 2, 3))
    print(funcyx(4, 2, 3))
'''