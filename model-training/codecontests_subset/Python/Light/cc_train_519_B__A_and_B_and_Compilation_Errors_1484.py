n = int(input())
a1 = [int(i) for i in input().split()]
a2 = [int(i) for i in input().split()]
a3 = [int(i) for i in input().split()]
a1.sort()
a2.sort()
a3.sort()

res = [a1[-1], a2[-1]]
for i in range(n-1):
    if a1[i]!=a2[i]:
        res[0] = a1[i]
        break
for i in range(n-2):
    if a2[i]!=a3[i]:
        res[1] = a2[i]
        break 
print("\n".join(str(r) for r in res))