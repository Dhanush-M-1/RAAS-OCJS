a, b, c = map(int, input().split())

def quadroot(a, b, c):
    roots = []
    negb = -1*b
    discriminant = (b**2 - 4*a*c)**(1/2)
    bottom = 2*a
    roots.append(format((negb - discriminant) / (bottom), ".6f"))
    roots.append(format((negb + discriminant) / (bottom), ".6f"))
    return roots

if a == 0 and b == 0 and c == 0:
    print(-1)
    exit()
if a == b and b == 0 and c != 0 or (b**2 - 4*a*c) < 0:
    print(0)
    exit()
ans = []
if a == 0:
    ans.append((-1*c) / b)
else:
    ans = quadroot(a, b, c)

for root in range(len(ans)):
    ans[root] = float(ans[root])

ans1 = list(set(sorted(ans)))
print(len(ans1))
for i in ans1:
    print((f'{i:.6f}'))


