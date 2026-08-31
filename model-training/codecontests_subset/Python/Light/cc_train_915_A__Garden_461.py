a, b = input().split()
mas = input().split()
n = []
for i in mas:
    if int(b) % int(i) == 0:
        n.append(int(int(b) / int(i)))
print(min(n))
