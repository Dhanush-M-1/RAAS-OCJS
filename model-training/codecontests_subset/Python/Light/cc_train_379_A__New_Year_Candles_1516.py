#n = int(input())
a, b = [int(x) for x in input().split()]
s = a
while not a<b:
    s += a//b
    a = a//b + a%b
print(s)
