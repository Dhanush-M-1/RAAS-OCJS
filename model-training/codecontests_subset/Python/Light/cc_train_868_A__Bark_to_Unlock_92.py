pas = input()
n = int(input())
one = False
two = False
three = False
for i in range(n):
    s = input()
    if s[0] == pas[1]:
        one = True
    if s[1] == pas[0]:
        two = True
    if s[0] == pas[0] and s[1] == pas[1]:
        three = True
if one and two:
    print("YES")
    exit(0)
if three:
    print("YES")
else:
    print("NO")
    