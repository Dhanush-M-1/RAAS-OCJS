n, k = map(int, input().split())
mas = list(map(int, input().split()))
mas.sort()
mas.reverse()
for i in range(n):
    if k%mas[i] == 0:
        print(k//mas[i])
        break