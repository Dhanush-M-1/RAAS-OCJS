#E58_A

q = int(input())

for i in range(0, q):
    ln = [int(j) for j in input().split(" ")]
    l = ln[0]
    r = ln[1]
    d = ln[2]
    if d > r or d < l:
        print(d)
    else:
        print(r + (d - r % d))
    
