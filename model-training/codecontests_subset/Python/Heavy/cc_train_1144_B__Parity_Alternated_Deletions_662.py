#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
#  code

if __name__ == "__main__":
    n = int(input())
    a = list(map(int,input().split()))
    a.sort()
    o = list(filter(lambda x: x%2 == 1, a))
    e = list(filter(lambda x: x%2 == 0, a))

    if len(o) == len(e):
        print('0')
        quit()
    if len(o) > len(e):
        x = len(o) - len(e) - 1
        s = 0
        for i in range(x):
            s += o[i]
        print(s)
        quit()
    else:
        x = len(e) - len(o) - 1
        s = 0
        for i in range(x):
            s += e[i]
        print(s)
        quit()