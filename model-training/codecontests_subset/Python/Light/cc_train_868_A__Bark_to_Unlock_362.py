password = input()
n = int(input())
first = list()
second = list()
test3 = False
for i in range(n):
    a = input();
    if a == password:
        test3 = True
    first.append(a[0])
    second.append(a[1])
test1 = False
test2 = False
for i in first:
    if password[1] == i:
        test1 = True
for i in second:
    if password[0] == i:
        test2 = True
if ((test1 and test2) or (test3)):
    print("YES")
else:
    print("NO")
