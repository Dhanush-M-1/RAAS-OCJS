p = int(input())
string = input()
d = string.count('8')
l = p // 11
if l <= d:
    print(l)
elif l>=d:
    print(d)
else:
    print("0")
