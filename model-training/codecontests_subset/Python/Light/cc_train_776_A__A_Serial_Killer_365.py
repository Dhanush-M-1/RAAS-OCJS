v1, v2 = input().split()
n = int(input())
print(v1, v2)
for i in range(n):
    dead, tv1 = input().split()
    if dead == v1:
        print(v2, tv1)
        v1 = tv1
    else:
        print(v1, tv1)
        v2 = tv1
