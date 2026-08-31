def gcd(a, b):
    a, b  = max(a, b), min(a, b)
    while a%b != 0:
        a, b = b, a%b
    return b

T = int(input())
set = []
for i in range(T):
    set.append([int(j) for j in input().split()])
 
for i in range(T):
    if set[i][0] < set[i][1] or set[i][1] > set[i][3]:
        print("No")
    elif set[i][2] >= set[i][1]:
        print("Yes")
    else:
        g = gcd(set[i][1], set[i][3])
        amodg = set[i][0]%g
        if set[i][1] - g + amodg <= set[i][2]:
            print("Yes")
        else:
            print("No")