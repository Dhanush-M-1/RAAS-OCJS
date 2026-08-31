k = input() # get password
n = int(input()) # number of words

list = []

while (n > 0):
    list.insert(n - 1, input())
    n = n - 1

c, d = k

r = False

for s in list:
    a, b = s
    if a == c:
        if b == d:
            r = True
            break
    if b == c:
        for t in list:
            e, f = t
            if e == d:
                r = True
                break


if r:
    print("YES")
else:
    print("NO")
