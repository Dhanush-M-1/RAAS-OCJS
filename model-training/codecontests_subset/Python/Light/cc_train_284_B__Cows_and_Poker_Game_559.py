n = int(input())
c = input()
f = c.count("F")
a = c.count("A")
i = c.count("I")
if i > 1:
    print(0)
elif i == 1:
    print(1)
else:
    print(a)