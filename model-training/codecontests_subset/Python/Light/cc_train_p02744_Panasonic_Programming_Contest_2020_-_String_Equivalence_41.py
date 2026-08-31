al=[chr(ord('a') + i) for i in range(26)]

def f(x,c):
    if len(x) == n:
        print(x)
    else:
        for i in range(c):
            f(x+al[i],c)
        f(x+al[c],c+1)

n = int(input())

f("a",1)