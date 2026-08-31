a = input().split()

n = int(input())

for _ in range(n):
    print(a[0]+" "+a[1])
    i = input().split()
    a.remove(i[0])
    a.append(i[1])

print(a[0]+" "+a[1])
