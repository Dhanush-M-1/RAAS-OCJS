def main():
    def solve():
        n = int(input())
        pp = [int(a) for a in input().split()]
        nmv = pp[n//2]
        fp = n//2 -1
        while fp >= 4 and pp[fp] == nmv:
            fp -=1
        if fp < 4:
            print('0 0 0')
            return
        gv = pp[0]
        g = 1
        while pp[g] == gv:
            g +=1
        s = g+1
        if g + s > fp:
            print('0 0 0')
            return
        sv = pp[g + s -1]
        while pp[g+s] == sv:
            s+=1
        if 2*g + s > fp:
            print('0 0 0')
            return
        else:
            b = fp - g - s + 1
        print(g, s, b)


    q = int(input())
    for _ in range(q):
        solve()


if __name__ == "__main__":
    main()