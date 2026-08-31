n = int (input())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]
adic = {}
for elem in a:
    adic[elem] = adic.get(elem,0) + 1
bdic = adic.copy()
for elem in b:
    adic[elem] = adic.get(elem,0) - 1
    if adic[elem] == 0:
        adic.pop(elem)
first = list(adic.keys())[0]
print(first)

adic = bdic.copy()
for elem in c:
    adic[elem] = adic.get(elem,0) - 1
    if adic[elem] == 0:
        adic.pop(elem)
cur = adic.keys()
if len (list(adic.keys())) == 1:
    print(list(adic.keys())[0])
else:
    a = list(adic.keys())[0]
    if a == first:
        print (list(adic.keys())[1])
    else:
        print (a)