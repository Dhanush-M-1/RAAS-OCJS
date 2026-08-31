n = int(input())
L = []
def f(s, m):
    if len(s) == n:
        L.append(s)
        return
    for i in range(97, m+2):
        f(s + chr(i), max(i, m))
f("a", 97)
for l in L:
    print(l)
