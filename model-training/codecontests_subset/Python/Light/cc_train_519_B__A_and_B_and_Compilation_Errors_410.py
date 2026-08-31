n=input()
n=int(n)
first=[int(x) for x in input().split()]
second=[int(x) for x in input().split()]
third=[int(x) for x in input().split()]
length=len(first)
first.sort()
second.sort()
third.sort()
second=second+['']
third=third+['']*2
for i in range(length):
    if first[i] != second[i]:
        print(first[i])
        break
for i in range(length):
    if second[i] != third[i]:
        print(second[i])
        break
