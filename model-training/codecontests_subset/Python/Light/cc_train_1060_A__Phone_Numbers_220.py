

a = int(input())
n = input()

b = n.count('8')

if a // 11 < b:
    print(a // 11)
else:
    print(b)