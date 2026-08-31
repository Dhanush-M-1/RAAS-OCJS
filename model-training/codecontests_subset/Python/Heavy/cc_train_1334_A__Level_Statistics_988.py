for _ in range(int(input())):
    n = int(input())
    ans = ''
    for i in range(n):
        p, c = map(int, input().split())
        if i == 0:
            prevp = p
            prevc = c
            if p < c:
                ans = 'NO'
        else:
            if p - prevp < c - prevc or c < prevc or p < prevp:
                ans = 'NO'
            elif p < c or p < prevc:
                ans = 'NO'
            prevp = p
            prevc = c
    if ans == '':
        ans = 'YES'
    print(ans)
    # list(map(int, input().split()))
