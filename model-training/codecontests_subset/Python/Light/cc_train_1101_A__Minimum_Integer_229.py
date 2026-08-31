q = int(input())
for i in range(0, q):
    numList1 = list(map(int, input().split()))
    l = numList1[0]
    r = numList1[1]
    d = numList1[2]
    if d < l:
        print(d)
    else:
        a = r // d
        print(d + a * d)
