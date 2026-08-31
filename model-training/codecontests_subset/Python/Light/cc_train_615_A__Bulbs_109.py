s = input().split()
n, m = map(int, s)
# print(n, m)

all_bulbs = set(range(1, m+1))
on_bulbs = set()

for i in range(n):
    s = input().split()
    s = list(map(int, s))
    xi = s[0]
    yi = s[1:]
    # print(xi, yi)
    on_bulbs.update(yi)

# print(on_bulbs)
# print(all_bulbs)
if on_bulbs == all_bulbs:
    print('YES')
else:
    print('NO')