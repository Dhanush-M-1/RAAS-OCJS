def unblock(lst, s):
    for i in range(len(lst)):
        for j in range(len(lst)):
            x = lst[i] + lst[j]
            if x.find(s) != -1:
                return "YES"
    return "NO"


t = input()
n = int(input())
a = list()
for z in range(n):
    y = input()
    a.append(y)
print(unblock(a, t))
