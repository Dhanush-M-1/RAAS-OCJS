n = int(input())

first = sorted(list(map(int,input().split())))
second = sorted(list(map(int,input().split())))
third = sorted(list(map(int,input().split())))
f = False
for i in range(n-1):
    if first[i] != second[i]:
        print(first[i])
        f = True
        break
if f == False:
    print(first[n-1])
else:
    f = False

for i in range(n-2):
    if second[i] != third[i]:
        print(second[i])
        f = True
        break
if f == False:
    print(second[n-2])
else:
    pass
