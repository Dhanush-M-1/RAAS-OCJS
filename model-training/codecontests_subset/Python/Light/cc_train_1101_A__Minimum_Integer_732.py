import math

def main():
    q = int(input())
    for i in range(q):
        l,r,d = map(int,input().split())
        if l%d == 0:
            l -= 1
        if l >= d:
            x = d
        else:
            if r%d == 0:
                r += 1
            x = int(d*math.ceil(r/d))

        print(x)

main()
