string = input()
pairs = [string]
names = string.split()
n = int(input())
for x in range(n):
    string = input()
    temp = string.split()
    names.remove(temp[0])
    names.append(temp[1])
    pairs.append(" ".join(names))
for x in pairs:
    print(x)