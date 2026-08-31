vedra, dlina = map(int, input().split())
dlinaOtrezkov = list(map(int, input().split()))
dlinaOtrezkov.sort()
dlinaOtrezkov.reverse()
counter = -5
for i in range(0, vedra):
    if dlinaOtrezkov[i] <= dlina and dlina % dlinaOtrezkov[i] == 0:
        counter = dlinaOtrezkov[i]
        break
    else:
        i = i
print(dlina // counter)
