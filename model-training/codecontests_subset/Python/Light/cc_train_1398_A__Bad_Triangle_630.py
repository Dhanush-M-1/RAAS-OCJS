cases = int(input())
for i in range(cases):
    n = int(input())
    line2 = input().split(' ')
    arr = []
    for a in line2:
        arr.append(int(a))
    mi = arr[0]
    pos = False
    for j in range(1,n):
        s = mi + arr[j]
        if s <= arr[-1]:
            print(1, j+1, n)
            pos = True
            break
    if not pos:
        print(-1)
        
            
