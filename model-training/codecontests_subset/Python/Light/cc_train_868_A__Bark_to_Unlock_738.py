s = input()
n = int(input())
start = s[0]
finish = s[1]
first = False
last = False
for i in range(n):
    t = input()
    if t[0] == finish:
        last = True
    if t[1] == start:
        first = True
    if (t[0] == start and t[1] == finish) or (first and last):
        print("YES")
        exit()
print("NO")
