from sys import stdin

def inp():
    return stdin.readline().strip()

t = int(inp())
for _ in range(t):
    n = int(inp())
    if n == 1:
        print(0)
    elif n == 3:
        print(2)
    else:
        c=0
        flag = False
        while True:
            if n==1:
                break
            if n%6 == 0:
                n/=6
            elif n%3 == 0:
                n *= 2
            else:
                print(-1)
                flag = True
                break
            c+=1
        if flag:
            continue
        else:
            print(c)