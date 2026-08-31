#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
#  code

if __name__ == "__main__":
    t = int(input())
    while t > 0:
        t -= 1
        n = int(input())
        s = str(input())
        c1 = 0
        c2 = 0
        for i in range(n):
            if s[i] == '<':
                c1 += 1
            else:
                break
        for i in range(n-1,-1,-1):
            if s[i] == '>':
                c2 += 1
            else:
                break
        print(min(c1,c2))

        