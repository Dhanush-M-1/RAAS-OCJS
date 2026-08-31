a,b = list(input())
a_set = set()
b_set = set()

match = False
for _ in range(int(input())):
    x,y = list(input())
    if x == a and y == b:
        match = True
    if a == x:
        a_set.add(0)
    if a == y:
        a_set.add(1)
    if b == x:
        b_set.add(0)
    if b == y:
        b_set.add(1)

if len(a_set) > 0 and len(b_set) > 0:
    if match or 1 in a_set and 0 in b_set:
        print("YES")
    else:
        print("NO") 
else:
    print("NO")
