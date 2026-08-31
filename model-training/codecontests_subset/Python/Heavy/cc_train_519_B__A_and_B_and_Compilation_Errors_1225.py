n = int(input())

arr1 = list(map(int, input().split()))

arr2 = list(map(int, input().split()))

arr3 = list(map(int, input().split()))

d1,d2,d3 = dict(),dict(),dict()

for i in arr1:
    
    if i in d1:
        
        d1[i] += 1
        
    else:
        
        d1[i] = 1
        
for i in arr2:
    
    if i in d2:
        
        d2[i] += 1
        
    else:
        
        d2[i] = 1
        
for i in arr3:
    
    if i in d3:
        
        d3[i] += 1
        
    else:
        
        d3[i] = 1
        
for i in arr1:
    
    if i not in d2 or (i in d2 and d2[i] != d1[i]):
        
        print(i)
        break
for i in arr2:
    
    if i not in d3 or (i in d3 and d3[i] != d2[i]):
        print(i)
        break