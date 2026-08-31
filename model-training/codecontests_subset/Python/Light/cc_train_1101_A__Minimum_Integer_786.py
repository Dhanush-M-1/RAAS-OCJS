
def f(l, r, d):
    if d>r:
        return d
    for i in range(d,l,d):
        if i%d ==0:
            return i
    return (int(r/d)+1)*d

n = int(input())

for i in range(n):
    row = input().split(' ')
    l = int(row[0])
    r = int(row[1])
    d = int(row[2])
    print(str(int(f(l,r,d))))


