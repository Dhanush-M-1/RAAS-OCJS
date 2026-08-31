t = int(input())
for i in range(t):
    l,r,d = input().split()
    l,r,d = int(l) , int(r) , int(d) 
    if d < l or d > r:
        print(d)
    else:
        print((r // d) * d + d)    