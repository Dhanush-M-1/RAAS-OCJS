a, b, L = list(map(int, input().split()))

memo = {}

#10^9 rougly equals 31700 * 31700
memo[(31701, 1)] = ((L - 31701) + 1)% 2
#2**30 > 10^9
memo[(1, 30)] = -1


for i in range(31700, a - 1, -1):
    for j in range(29, b - 1, -1):
        if i**j>=L:
            continue
        
        s = set()
        if (i + 1) ** j < L:
            s.add(memo[(i + 1, j)])
        if i ** (j + 1) < L:
            s.add(memo[(i, j + 1)])

        if 0 not in s and -1 in s:
            memo[(i, j)] = -1
        else:
            mex = 0
            while mex in s:
                mex += 1
            memo[(i, j)] = mex

if memo[(a, b)] > 0:
    print("Masha")
elif memo[(a, b)] == -1:
    print("Missing")
else:
    print("Stas")
