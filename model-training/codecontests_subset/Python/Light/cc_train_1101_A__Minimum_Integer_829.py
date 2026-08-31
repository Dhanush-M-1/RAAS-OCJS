q = int(input())
for i in range (q):
    l,r,d=map(int, input().split())
    x = d
    if x < l or x > r:
        print(x)
        continue
    t = r//d + 1
    x = d * t
    print (x)