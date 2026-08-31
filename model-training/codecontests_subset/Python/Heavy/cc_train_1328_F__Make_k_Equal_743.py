import sys
def main():
    def input():
        return sys.stdin.readline()[:-1]
    n, l = map(int,input().split())
    a = list(map(int,input().split()))
    ans = 10000
    for e in range(1,max(a)+1):
        d = []
        t = 0
        for k in range(n):
            s = 0
            b = 0
            if a[k] == e:
                d.append(0)
            elif a[k] > e:
                b = a[k]
                while b > e:
                    b //= 2
                    s += 1
                if b == e:
                    d.append(s)
                else:
                    d.append(10000)
            elif a[k] < e:
                d.append(10000)
        ans = min(ans,sum(sorted(d)[:l]))
    print(ans)
if __name__ == '__main__':
    main()
