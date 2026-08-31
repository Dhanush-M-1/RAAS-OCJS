for _ in range(int(input())):
    le = int(input())

    f, s, *_, la = [int(i) for i in input().split()]

    print(1, 2, le) if f + s <= la else print(-1)