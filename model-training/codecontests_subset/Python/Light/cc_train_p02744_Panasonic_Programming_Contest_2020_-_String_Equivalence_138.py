N = int(input())

def f(s):
    if len(s) == N:
        print(s)
        return
    for i in range(97, ord(max(list(s)))+1+1):
        ns = s + chr(i)
        f(ns)

f('a')