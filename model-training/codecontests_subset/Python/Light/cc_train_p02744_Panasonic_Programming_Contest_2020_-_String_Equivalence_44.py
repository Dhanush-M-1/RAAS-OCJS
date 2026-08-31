N = int(input())

def f(s, mx):
    if len(s) == N:
        print(s)
        return
    for i in range(mx+1):
        f(s + chr(ord("a") + i), max(mx, i+1))

f("", 0)
