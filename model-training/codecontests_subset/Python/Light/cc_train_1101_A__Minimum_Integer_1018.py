def main():
    q = int(input())
    for i in range(q):
        s = [int(x) for x in input().split()]
        l = s[0]
        r = s[1]
        d = s[2]
        if d < l or d > r:
            print(d)
        else:
            a = r // d
            print(d * (a + 1))



main()
