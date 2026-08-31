num = int(input())
x = 0
for i in range(num):
    l, r, d = map(int, input().split())
    if d < l:
        print(d)
    else:
        x = r
        x += d - r % d
        print(x)
            
        