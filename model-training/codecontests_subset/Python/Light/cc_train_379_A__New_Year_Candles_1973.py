from sys import stdin

a, b = (int(x) for x in stdin.readline().strip().split(' '))

result = a

while a >= b:
    result += int(a/b)
    a = int(a/b) + a - int(a/b)*b

print(result)
