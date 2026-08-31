import sys, math

def input():
    return sys.stdin.readline()[:-1]

def main():
    q = int(input())
    for _ in range(q):
        n = int(input())
        p = list(map(int,input().split()))
        now = 0
        g = 0
        f = 0
        for k in range(n):
            if p[k] == p[0]:
                g += 1
            else:
                f = k
                now = p[k]
                break
        if g+g+1+g+1 > n//2 or n < 10:
            print("0 0 0")
        else:
            s = 0
            now = p[g+g]
            for k in range(f,n):
                if p[k] >= now:
                    s += 1
                else:
                    now = p[k]
                    f = k
                    break
            cur = 0
            b = 0
            for k in range(f,n):
                if now == p[k]:
                    cur += 1
                else:
                    if cur + b + s + g > n//2:
                        break
                    else:
                        b += cur
                        cur = 1
                        now = p[k]
            if g < s and g < b and g*b*s != 0:
                print(g,s,b)
            else:
                print("0 0 0")

if __name__ == '__main__':
    main()
