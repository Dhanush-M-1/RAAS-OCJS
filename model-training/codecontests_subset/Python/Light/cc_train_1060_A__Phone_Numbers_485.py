n = int(input())
k = str(input())
q = 0
for i in k:
    if i == "8":
        q += 1
if (len(k) - len(k) % 11) / 11 > q:
    print(q)
else:
    print(int((len(k) - len(k) % 11) / 11))