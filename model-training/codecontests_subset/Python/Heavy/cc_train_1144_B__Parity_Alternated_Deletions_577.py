n = int(input())
a = [int(i) for i in input().split()]
odd = []
even = []
for i in a:
    if i % 2 == 0:
        even.append(i)
    else:
        odd.append(i)
even.sort()
odd.sort()
ans = 10e10
for k in range(2):
    i = k
    o = odd.copy()
    e = even.copy()
    while True:
        if i % 2 == 0:
            if len(e) == 0:
                break
            e.pop()
        else:
            if len(o) == 0:
                break
            o.pop()
        i += 1
    ans = min(ans, sum(e) + sum(o))
print(ans)
