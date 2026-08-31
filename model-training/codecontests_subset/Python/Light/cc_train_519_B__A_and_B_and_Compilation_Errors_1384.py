n = int(input())
lis1 = [int(_) for _ in input().split()]
lis2 = [int(_) for _ in input().split()]
lis3 = [int(_) for _ in input().split()]

dic1 = {}
for x in lis1:
    dic1[x] = dic1.setdefault(x, 0) + 1
    
dic2 = {k:v for k,v in dic1.items()}
for x in lis2:
    dic1[x] -= 1
    
for k in dic1:
    if dic1[k] == 1:
        ans1 = k
        
dic2[ans1] -= 1
for x in lis3:
    dic2[x] -= 1
for k in dic2:
    if dic2[k] == 1:
        ans2 = k
        
print(ans1)
print(ans2)