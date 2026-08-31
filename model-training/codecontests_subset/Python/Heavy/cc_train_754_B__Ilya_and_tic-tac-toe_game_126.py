a = []
for i in range(4):
    s = input()
    for elem in s:
        a.append(elem)
def c(q, w, e):
    q -= 1
    w -= 1
    e -= 1
    q = a[q]
    w = a[w]
    e = a[e]
    kr = 0
    ps = 0
    if (q == 'o') or (w == 'o') or (e == 'o'):
        return False
    if (q == 'x'):
        kr += 1
    if (w == 'x'):
        kr += 1
    if (e == 'x'):
        kr += 1
    if (kr == 2):
        print("YES")
        exit()
        return True
    else:
        return False
c(1, 2, 3)
c(2, 3, 4)
c(5, 6, 7)
c(6, 7, 8)
c(9, 10, 11)
c(10, 11, 12)
c(13, 14, 15)
c(14, 15, 16)

c(1, 5, 9)
c(5, 9, 13)
c(2, 6, 10)
c(6, 10, 14)
c(3, 7, 11)
c(7, 11, 15)
c(4, 8, 12)
c(8, 12, 16)

c(1, 6, 11)
c(5, 10, 15)
c(2, 7, 12)
c(6, 11, 16)

c(3, 6, 9)
c(7, 10, 13)
c(4, 7, 10)
c(8, 11, 14)

print("NO")
