I = lambda: input().split()
n0 = I()
print(" ".join(n0))
for i in range(int(input())):
    n = I()
    n0[n0.index(n[0])] = n[1]
    print(" ".join(n0))