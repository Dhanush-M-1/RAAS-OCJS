n = int(input())
a = list(map(int, input().split()))
s_a = sorted(a)
m = int(input())
req = []
for _ in range(m):
    req.append(list(map(int, input().split())))

d = dict()
for r in req:
    if r[0] in d.keys():
        print(d[r[0]][r[1] - 1])
    else:
        del_indx = []
        for e in s_a[:n-r[0]]:
            for i in reversed(range(n)):
                if a[i] == e:
                    if i not in del_indx:
                        del_indx.append(i)
                        break
        new_a = []
        for i in range(n):
            if i not in del_indx:
                new_a.append(a[i])

        d[r[0]] = new_a
        print(d[r[0]][r[1] - 1])