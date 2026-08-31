# 1334A
t = int(input())

while t:
    n = int(input())
    a = []
    b = []
    d = 0
    z = 0
    x = 0
    for i in range(n):
        q,w = map(int,input().split())
        a.append(q)
        b.append(w)
    for i in range(n):
        if (a[i] < z or b[i] < x) or (b[i] - x > a[i] - z):
            print('NO')
            d += 1
            break
                
        else:
            z = a[i]
            x = b[i]
                
    if d == 0:
        print("YES")
        
    t -= 1
        