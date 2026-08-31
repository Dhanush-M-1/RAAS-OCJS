def main():
    (n, k,) = map(int, input().split(' '))


    ta = []
    tb = []
    tc = []

    for i in range(n):
        t, a, b = map(int, input().split(' '))
        if a==1 and b==1:
            tc .append(t)
        elif a==1:
            ta.append(t)
        elif b==1:
            tb.append(t)
    ta.sort()
    tb.sort()
    tc.sort()

    if len(ta) + len(tc) < k or len(tb) + len(tc) < k:
        return -1

    ta.append(10**5)
    tb.append(10 ** 5)
    tc.append(10 ** 5)

    na = 0
    nb = 0
    nc = 0
    T = 0
    while na+nc<k and nb+nc<k:

        while tc[nc] <= ta[na] + tb[nb]:
            T += tc[nc]
            nc += 1
            if na+nc >= k and nb+nc >= k:
                return T
        if na+nc<k:
            T += ta[na]
            na +=1
        if nb+nc<k:
            T += tb[nb]
            nb +=1


        while nb+nc>=k and na+nc<k:
            if tc[nc] <= ta[na]:
                T += tc[nc]
                nc +=1
            else:
                T += ta[na]
                na +=1

        while na+nc>=k and nb+nc<k:
            if tc[nc] <= tb[nb]:
                T += tc[nc]
                nc +=1
            else:
                T += tb[nb]
                nb +=1

    return T


#for _ in range(int(input())):
print(main())
