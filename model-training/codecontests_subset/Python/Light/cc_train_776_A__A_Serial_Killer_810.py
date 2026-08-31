R = lambda:[x for x in input().split()]
one, two = R()
print(one, two)
n = int(input())
for _ in range(n):
    aone, atwo = R()
    if one == aone: one = atwo
    if two == aone: two = atwo
    print(one, two)