n = int(input())
l, nl = -(10**10), 0
r, nr = -(10**10), 0
for i in range(n):
    x, h = [int(x) for x in input().split()]

    left = x-h
    right = x+h

    if left > r:
        new_nl = nr + 1
    elif left > l:
        new_nl = nl + 1
    elif x > r:
        new_nl = nr
    else:
        new_nl = nl
    new_l = x

    if x > r:
        new_nr = nr + 1
    else:
        new_nr = nl + 1
    new_r = right

    l, nl, r, nr = new_l, new_nl, new_r, new_nr
print(max(nl, nr))
    
        
        
