t = int(input())

while t:
    n = int(input())
    sides = list(map(int, input().split()))
    if sides[0] + sides[1] > sides[-1]:
        print(-1)
    else:
        print(1, 2, n)
    t -= 1