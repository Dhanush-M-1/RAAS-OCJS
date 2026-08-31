#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
#  code

def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        a = list(map(int, input().split()))
        ok = 0
        for i, v in enumerate(a[2:]):
            if v >= a[0] + a[1]:
                print(1,2,i + 3)
                ok = 1
                break
        if not ok:
            print(-1)
    return

if __name__ == "__main__":
    main()