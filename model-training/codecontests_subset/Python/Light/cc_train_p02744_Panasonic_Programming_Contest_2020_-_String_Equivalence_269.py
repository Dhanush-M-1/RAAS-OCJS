def rec(w, x, n):
    if len(w) == n:
        return print(w)
    else:
        for i in range(x + 1):
            rec(w + chr(ord('a') + i), x + 1 if i == x else x, n)


n = int(input())
rec("", 0, n)