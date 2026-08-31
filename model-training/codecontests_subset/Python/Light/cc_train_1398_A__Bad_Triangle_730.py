t = int(input())
r = ""
for i in range(t):
    n = int(input())
    a = []
    a = input().split()
    if int(a[0]) + int(a[1]) <= int(a[len(a) - 1]):
        r += "1 2 " + str(len(a)) + "\n"
    else:
        r += "-1\n"
    """
    for j in range(n):
        b = int(a[j])
    for j in range(n):
        for k in range(n):
            for z in range(n):
                if (j != k) and (k != z) and (b[j] + b[k] <= b[z]):
                    r += str(i) + " " + str(j) + " " + str(k) + "\n"
                    break
    """
print(r)