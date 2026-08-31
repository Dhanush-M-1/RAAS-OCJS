n = list(input().split())
print(n[0] + " " + n[1])
c = int(input())
for _ in range(c):
    k = list(input().split())
    if k[0] == n[0]:
        print(k[1] + " " + n[1])
        n[0] = k[1]
    if k[0] == n[1]:
        print(n[0] + " " + k[1])
        n[1] = k[1]
