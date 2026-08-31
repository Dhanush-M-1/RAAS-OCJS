input()
a1 = sorted(input().split())
a1copy = a1.copy()
a2 = sorted(input().split())
a2copy = a2.copy()
a3 = sorted(input().split())
for i in a2:
    if i in a1copy:
        del a1copy[a1copy.index(i)]
print(a1copy[0])
for i in a3:
    if i in a2copy:
        del a2copy[a2copy.index(i)]
print(a2copy[0])
