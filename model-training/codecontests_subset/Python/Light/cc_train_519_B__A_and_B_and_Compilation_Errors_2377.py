n = int(input())
a, b, c = 0, 0, 0
for s in input().split():
    a += int(s)
for s in input().split():
    b += int(s)
for s in input().split():
    c += int(s)
print(a-b,b-c, sep='\n')