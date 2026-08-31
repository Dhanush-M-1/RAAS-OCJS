def first(m):
    cur = m[-1]
    if len(m) >= 2:
        k = 0
        while cur == m[-1]:
            del m[-1]
            if len(m) == 0:
                return False
        if len(m) <= 2:
            return False
        return m
    else:
        return False


def ge(mj):
    ans = 1
    for i in range(len(mj) - 1):
        if mj[i] == mj[i + 1]:
            ans += 1
        else:
            return ans
    return ans


def sj(mk):
    ans = 1
    for i in range(len(mk) - 1):
        if mk[i] == mk[i + 1]:
            ans += 1
        else:
            return ans
    return ans


for t in range(int(input())):
    n = int(input())
    mas = list(map(int, input().split()))
    mas = mas[:n // 2 + 1]
    mas = first(mas)
    if mas == False:
        print("0 0 0")
    else:
        g = ge(mas)
        mas = mas[g:]
        s = 0
        while s <= g:
            c = sj(mas)
            s += c
            mas = mas[c:]
        b = len(mas)
        if g == 0 or s == 0 or b == 0:
            print("0 0 0")
        elif g >= s or g>=b:
            print("0 0 0")
        else:
            print(g,s,b)
