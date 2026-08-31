n = int(input())
a = []
f = 1
b = [1, 2]
for i in range(n):
    a.append(int(input()))
for i in range(n):
    if a[i] == 1:
        if b == [1, 2]:
            b = [1, 3]
        elif b == [2, 1]:
            b = [3, 1]
        elif b == [1, 3]:
            b = [1, 2]
        elif b == [3, 1]:
            b = [2, 1]
        else:
            f = 0
            break
    if a[i] == 2:
        if b == [1, 2]:
            b = [3, 2]
        elif b == [2, 1]:
            b = [2, 3]
        elif b == [2, 3]:
            b = [2, 1]
        elif b == [3, 2]:
            b = [1, 2]   
        else:
            f = 0
            break
    if a[i] == 3:
        if b == [3, 2]:
            b = [3, 1]
        elif b == [2, 3]:
            b = [1, 3]
        elif b == [1, 3]:
            b = [2, 3]
        elif b == [3, 1]:
            b = [3, 2]   
        else:
            f = 0
            break    
if f == 1:
    print("YES")
else:
    print("NO")