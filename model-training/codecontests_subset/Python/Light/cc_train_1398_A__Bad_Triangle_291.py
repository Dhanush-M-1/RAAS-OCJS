for i in range(int(input())):
    n = int(input())
    k = 0
    mas = [int(i) for i in input().split()]
    for i in range(2, n):
        if mas[0] + mas[1] <= mas[i]:
            print(1, 2, i+1)
            k += 1
            break
    if k == 0:
        print(-1)