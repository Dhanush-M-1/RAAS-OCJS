n = int(input())
c = 1
op = int(input().split()[0])
for i in range(n-1):
    p,l=map(int, input().split())
    if op < p:#last
        c += 1
    else:
        op = op-l0
    if p-l>op:
        op = p
    else:
        op = p + l
        l0 = l
print([c,1][n==1])