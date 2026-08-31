def p(lst, ind):
    lst = lst[ind].split(" ")
    p = lst[0]
    return int(p)
def c(lst, ind):
    lst = lst[ind].split(" ")
    c = lst[1]
    return int(c)
t = int(input())
for i in range(t):
    n = int(input())
    lst = []
    for j in range(n):
        p_c = input()
        lst.append(p_c)
    for k in range(n-1):
        if p(lst, k) == p(lst, k + 1) and c(lst, k) != c(lst, k + 1) or p(lst, k + 1) - p(lst, k) < c(lst, k + 1) - c(lst, k):
            print("NO")
            break
        elif c(lst, k + 1) <= p(lst, k + 1) >= p(lst, k) >= c(lst, k) <= c(lst, k + 1):
            continue
        else:
            print("NO")
            break
    else:
        if n == 1 and p(lst, 0) < c(lst, 0):
            print("NO")
        else:
            print("YES")