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
        a = list(map(int ,input().split()))
        s = set()
        for i in range(n - 1):
            if a[i] == -1 and a[i + 1] != -1:
                s.add(i + 1)
            elif a[i] > -1 and a[i + 1] == -1:
                s.add(i)
        if len(s) == 0:
            print("0 0")
        else:
            b = [a[i] for i in s]
            k1 = (min(b) + max(b))//2
            k2 = (min(b) + max(b) + 1)//2

            c = a[:]
            for i,v in enumerate(a):
                if v == -1:
                    c[i] = k1
                    a[i] = k2
            
            m1 = -100
            m2 = -100

            for i in range(n - 1):
                m1 = max(m1 , abs(c[i] - c[i + 1]))
                m2 = max(m2 , abs(a[i] - a[i + 1]))

            if m1 <= m2:
                print(m1 , k1)
            else:
                print(m2 , k2)
    return

if __name__ == "__main__":
    main()