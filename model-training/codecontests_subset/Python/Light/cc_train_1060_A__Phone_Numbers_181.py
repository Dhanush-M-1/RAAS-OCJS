
n = input()
m = input()
counter = 0
for i in range(len(m)):
    if m[i] == "8":
        counter += 1

c = len(m) // 11

print(min(c, counter))