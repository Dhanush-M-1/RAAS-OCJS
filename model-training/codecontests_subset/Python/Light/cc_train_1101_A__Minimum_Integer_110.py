q = int(input())
for i in range(0, q):
    s = input()
    left = int(s.split(" ")[0])
    right = int(s.split(" ")[1])
    d = int(s.split(" ")[2])
    div = 1
    if d * div in range(left, right + 1):
        div = int(right / d) + 1
    print(d * div)
