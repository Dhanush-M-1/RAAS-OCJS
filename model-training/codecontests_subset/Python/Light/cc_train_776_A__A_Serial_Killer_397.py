p1,p2 = input().split()
n = int(input())
print(p1,p2)
for i in range(n):
    killed,potential = input().split()
    if killed == p1:
        print(p2, potential)
        p1 = potential
    elif killed == p2:
        print(p1, potential)
        p2 = potential
