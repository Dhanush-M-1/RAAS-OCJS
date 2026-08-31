a1 = input()
a2 = list(map(int,input().strip().split()))
a3 = list(map(int,input().strip().split()))
a4 = list(map(int,input().strip().split()))

b2 = sum(a2)
b3 = sum(a3)
b4 = sum(a4)

print(b2-b3)
print(b3-b4)