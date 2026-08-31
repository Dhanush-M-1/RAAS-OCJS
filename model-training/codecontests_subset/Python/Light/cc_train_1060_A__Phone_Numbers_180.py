n = int(input())
a = list(input())
k = 0
if n < 11:
    print(0)
    exit()
else:
    p = 0
    for i in range(len(a)):
        if a[i] == "8":
            p += 1
        f = len(a) // 11
    print(min(f,p))