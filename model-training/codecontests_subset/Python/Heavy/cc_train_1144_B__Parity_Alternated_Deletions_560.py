n = int(input())
a = list(map(int, input().split()))
a.sort()
odd = 0
even = 0
for i in a:
    if i % 2 == 0:
        even += 1
    else:
        odd += 1
summ = 0
if odd+1 > even:
    ac = odd - even - 1
    add = 0
    for i in a:
        if add < ac:
            if i % 2 == 1:
                summ += i
                add += 1
        else:
            break
elif even+1 > odd:
    ac = even - odd - 1
    add = 0
    for i in a:
        if add < ac:
            if i % 2 == 0:
                summ += i
                add += 1
        else:
            break
print(summ)
