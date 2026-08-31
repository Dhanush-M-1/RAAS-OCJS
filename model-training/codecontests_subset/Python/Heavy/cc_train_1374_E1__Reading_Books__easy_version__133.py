def solution():
    s = input().split()
    n = int(s[0])
    k = int(s[1])
    yyLike = []
    xqLike = []
    bothLike = []
    s = 0
    for i in range(n):
        line = input().split()
        cost = int(line[0])
        if line[1] == '1' and  line[2] == '1':
            bothLike.append(cost)
        elif line[1] == '1':
            yyLike.append(cost)
        elif line[2] == '1':
            xqLike.append(cost)

    yyLike.sort()
    xqLike.sort()
    bothLike.sort()
    yyLike.reverse()
    xqLike.reverse()
    bothLike.reverse()

    while k > 0 and len(bothLike) > 0:
        if len(yyLike) > 0 and len(xqLike) > 0:
            if bothLike[-1] < yyLike[-1] + xqLike[-1]:
                s += bothLike.pop()
                k -= 1
            else:
                s += yyLike.pop()
                s += xqLike.pop()
                k -= 1
        else:
            k -= 1
            s += bothLike.pop()

    while k > 0:
        if len(yyLike) == 0 or len(xqLike) == 0:
            return(-1)
        k -= 1
        s += yyLike.pop()
        s += xqLike.pop()
    return(s)
print(solution())