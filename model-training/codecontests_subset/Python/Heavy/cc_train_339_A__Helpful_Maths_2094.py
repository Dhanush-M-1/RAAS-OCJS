# Helpful Maths
s = input()
one = 0
two = 0
three = 0
for i in range(len(s)):
    if s[i] == '1':
        one += 1
    elif s[i] == '2':
        two += 1
    elif s[i] == '3':
        three += 1;
if one > 0:
    print("1", end="")
for i in range(one-1):
    print("+1", end="")
if two > 0 and one == 0:
    print("2", end="")
    for i in range(two-1):
        print("+2", end="")
else:
    for i in range(two):
        print("+2", end="")
if three > 0 and one == 0 and two == 0:
    print("3", end="")
    for i in range(three-1):
        print("+3", end="")
else:
    for i in range(three):
        print("+3", end="")


