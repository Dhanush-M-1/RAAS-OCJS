#  =========     /\       /|    |====/|
#      |        /  \       |    |   / |
#      |       /____\      |    |  /  |
#      |      /      \     |    | /   |
#  ========= /        \  =====  |/====|  
#  code

def main():
    n,p,w,d = map(int, input().split())
    for y in range(w):
        x = p - y * d
        if x % w == 0 and x >= 0:
            x //= w
            if n - y - x >= 0:
                print(x ,y , n - x - y)
                return
    print(-1)
    return

if __name__ == "__main__":
    main()