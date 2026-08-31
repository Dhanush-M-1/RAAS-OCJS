(a, b) = input().split()

n = int(input())

print(a, b)
for i in range(n):
    (a1, a2) = input().split()
    if a == a1:
        a = a2
    elif b == a1:
        b = a2
    elif a == a2:
        a = a1
    elif b == a2:
        b = a1        
    print(a, b)