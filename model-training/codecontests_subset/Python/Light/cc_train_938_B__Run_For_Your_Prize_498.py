n = int(input())
mas = list(map(int, input().split()))
mas = [0] + mas
midle = 10 ** 6 // 2
ind = 0
for i in range(n + 1):
    if mas[i] > midle:
        ind = i
        break
if ind:
    sec_1 = mas[ind - 1] - 1
    sec_2 = 10 ** 6 - mas[ind]
else:
    sec_1 = mas[-1] - 1
    sec_2 = 0
print(max(sec_1, sec_2))
