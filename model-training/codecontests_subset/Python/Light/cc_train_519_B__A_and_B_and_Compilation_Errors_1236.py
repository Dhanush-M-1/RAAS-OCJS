input();a=[]
for i in range(3):
    a.append({})
    s = input().split()
    for c in s:
        try:
            a[i][c] = a[i][c]+1
        except KeyError:
            a[i][c] = 1
for i in range(2):
    print((set(a[i].items())-set(a[i+1].items())).pop()[0])


