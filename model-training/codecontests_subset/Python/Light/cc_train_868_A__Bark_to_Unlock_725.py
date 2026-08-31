target = input()
n = int(input())
a = []
ok = 'NO'
for i in range(n):
    a.append(input())
    if target == a[i]:
        ok = 'YES'
        pass
    elif target == a[i][::-1]:
        ok = 'YES'
        pass
    continue
for i in a:
    for j in a:
        if i != j:
            if target in i + j:
                ok = 'YES'
                pass
            elif target in j + i:
                ok = 'YES'
                pass
print(ok)
