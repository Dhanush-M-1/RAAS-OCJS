
t = int(input())

for i in range(t):
    n = int(input())
    mas = list(map(int, input().split()))
    if (len(mas) < 3):
        print(-1)
    else:
        if (mas[0]+mas[1] > mas[-1]):
            print(-1)
        else:
            print(1,2,len(mas))