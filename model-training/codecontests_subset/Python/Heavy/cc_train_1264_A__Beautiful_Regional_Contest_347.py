t = int(input())

for t_i in range(t):
    n = int(input())
    P = input().split()
    P = [int(k) for k in P]

    mxm = n // 2
    
    i = 1
    while(i < mxm and P[i] == P[i - 1]):
        i += 1
    n_g = i

    i += n_g + 1
    while (i < mxm and P[i] == P[i - 1]):
        i += 1
    n_s = i - n_g

    i += n_g + 1
    n_b = -1
    while i <= mxm:
        if P[i] != P[i - 1]:
            n_b = i - n_g - n_s
        i += 1

    if n_b == -1:
        print("0 0 0")
    else:
        print(' '.join([str(n_g), str(n_s), str(n_b)]))
