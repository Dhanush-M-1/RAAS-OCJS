import sys
# sys.stdin = open(r'input/A.txt')

t = int(input())

inp = [line.strip().split() for line in reversed(sys.stdin.readlines())]

while t:
    n = int(inp.pop()[0])
    c = [-1] * n
    p = [-1] * n
    prevp = 0
    prevc = 0
    #print(n)
    wrong_flag = False
    for i in range(n):
        p, c = map(int, inp.pop())
        if c - prevc > p - prevp or c < prevc or p < prevp or c > p:
            wrong_flag = True
        prevp = p
        prevc = c
    if wrong_flag:
        print("NO")
    else:
        print("YES")
    t -= 1
