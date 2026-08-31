n, k = map(int, input().split())
v = list(map(int, input().split()))

t_min = 10000
for vi in v:
    if k % vi == 0:
        t = k // vi
        if t < t_min:
            t_min = t

print(t_min)


# print(n, k)
# print(v)