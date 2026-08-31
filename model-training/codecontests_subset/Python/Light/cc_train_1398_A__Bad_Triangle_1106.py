def check(n):
    i = 0
    mi = n[2]
    ma = n[-1]
    while i <= len(n)-3:
        a = n[i]
        b = n[i+1]
        c = n[i+2]

        if a + b <= ma:
            return [i, i+1, len(n)-1]
        elif a + b <= c:
            return [i, i+1, i+2]
        i+=1
    return [-1]



for _ in range(int(input())):
    k = int(input())
    l = list(map(int, input().split(' ')))

    o = check(l)
    if len(o) == 1:
        print(-1)
    else:
        for k in o:
            print(k+1, end=' ')
        print()