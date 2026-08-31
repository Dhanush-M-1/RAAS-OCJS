x = int(input())
s = input()
if x < 11:
    print("0")
else:
    x1 = x//11
    c = s.count('8')
    if c < x1:
        print(c)
    else:
        print(x1)