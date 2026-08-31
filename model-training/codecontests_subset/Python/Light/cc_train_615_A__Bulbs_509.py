n, m = map(int, input().split(" "))

al = set()

for i in range(n):
    temp = list(map(int, input().split(" ")))
    for i in temp[1:]:
        al.add(i)

if len(al) != m:
    print ("NO")
else:
    print ("YES")

