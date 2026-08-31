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
        a = list(map(int , input().split()))
        s = set()
        for idx , i in enumerate(a):
            s.add((idx + i) % n)
        print('YES' if len(s) == n else 'NO') 
    return

if __name__ == "__main__":
    main()