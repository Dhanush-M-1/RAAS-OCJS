
lpn = int(input())

for loop in range(lpn):

    N = int(input())

    p = list(map(int,input().split()))

    lis = [1]

    for i in range(N-1):
        i += 1

        if p[i-1] == p[i]:
            lis[-1] += 1
        else:
            lis.append(1)

    g = lis[0]
    s = 0
    b = 0
    slf = 0
    for i in range(len(lis)-1):
        i += 1

        if slf == 0:
            s += lis[i]
            
            if s > g:
                slf = 1

        elif slf == 1:

            if g+s+b+lis[i] <= N // 2:
                b += lis[i]
            else:
                break

    if g<s and g<b and g+s+b<=N//2:
        print (g,s,b)
    else:
        print (0,0,0)
            
