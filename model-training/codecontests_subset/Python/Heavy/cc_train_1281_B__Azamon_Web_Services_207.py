#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
#  code

def main():
    t = int(input())
    for _ in range(t):
        s,c = map(str , input().split())
        ss = list(s)
        cc = list(c)
        sss = ss[:]
        sss.sort()
        k = -1
        for i in range(len(s)):
            if sss[i] != ss[i]:
                k = i
                break
        if s < c:
            print(s)
        else:
            if k != -1:
                for i in range(len(s) - 1 , k , -1):
                    if ss[i] == sss[k]:
                        ss[k],ss[i] = ss[i] , ss[k]
            p = ''.join(ss)
            if p < c:
                print(p)
            else:
                print("---")
    return


if __name__ == "__main__":
    main()
