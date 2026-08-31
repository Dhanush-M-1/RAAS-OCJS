def f(c, ans):
    if c != 0:
        print(c)
        for i in range(c):
            print(ans[i][0], ans[i][1])
    else:
        print(c)

def main():
    t = int(input())
    for i in range(t):
        x = int(input())
        a = [input() for i in range(x)]
        a1 = a[0][1]
        a2 = a[1][0]
        a3 = a[x - 2][x - 1]
        a4 = a[x - 1][x - 2]
        c = 0
        ans = []
        if a1 == a2:
            v = str(a1)
            if a3 == v:
                c += 1
                ans.append((x-1, x))
            if a4 == v:
                c += 1
                ans.append((x, x-1))
            f(c, ans)
        elif a3 == a4:
            v = str(a3)
            if a1 == v:
                c += 1
                ans.append((1, 2))
            if a2 == v:
                c += 1
                ans.append((2, 1))
            f(c, ans)
        else:
            if a1 != '0':
                c += 1
                ans.append((1, 2))
            if a2 != '0':
                c += 1
                ans.append((2, 1))
            if a3 != '1':
                c += 1
                ans.append((x - 1, x))
            if a4 != '1':
                c += 1
                ans.append((x, x - 1))
            f(c, ans)


main()
