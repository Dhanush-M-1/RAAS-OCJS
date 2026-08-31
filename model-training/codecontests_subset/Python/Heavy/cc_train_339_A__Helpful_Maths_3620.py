def sort(a, l, r):
    if (r - l <= 1):
        return
    m = a[l]
    x = l
    y = l
    for i in range(l, r):
        if (a[i] < m):
            a[x], a[i] = a[i], a[x]
            if (x != y):
                a[y], a[i] = a[i], a[y]
            x += 1
            y += 1
        elif (a[i] == m):
            a[y], a[i] = a[i], a[y]
            y += 1
    sort(a, l, x)
    sort(a, y, r)

def main():
    s = list(map(int,input().split('+')))
    sort(s, 0, len(s))
    for i in range(len(s)):
        if (i != len(s) - 1):
            print(s[i], end = '+')
        else:
            print(s[i])
main()