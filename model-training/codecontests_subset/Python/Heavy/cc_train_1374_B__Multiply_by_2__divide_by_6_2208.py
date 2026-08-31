GI = lambda: int(input()); GIS = lambda: map(int, input().split()); LGIS = lambda: list(GIS())

def main():
    for t in range(GI()):
        n = GI()
        threes = twos = 0

        while not n % 3:
            threes += 1
            n //= 3

        while not n % 2:
            twos += 1
            if twos > threes:
                print(-1)
                break
            n //= 2
        else:
            if n != 1:
                print(-1)
            else:
                print(threes + (threes - twos))
main()
