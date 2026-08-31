n = int(input())

def f(l, r, d):
    if d < l:
        print(d)
    else:
        x = r // d
        print(d * (x + 1))

for i in range(n):
    l, r, d = map(int, input().split())
    f(l, r, d)