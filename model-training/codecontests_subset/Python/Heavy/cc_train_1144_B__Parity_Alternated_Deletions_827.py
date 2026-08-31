
n = int(input())
a = list(map(int, input().split()))
a = sorted(a)
even = 0
odd = 0
count = 0
tmp = 0
for i in a:
    if i % 2 == 0:
        even += 1
    else:
        odd += 1
if even == odd or odd == even + 1:
    print(0)
    exit()
elif even > odd:
    for i in a:
        if tmp == (even - odd - 1):
            break
        if i % 2 == 0:
            count += i
            tmp += 1
elif odd > even:
    for i in a:
        if tmp == (odd - even - 1):
            break
        if i % 2 != 0:
            count += i
            tmp += 1
print(count)
