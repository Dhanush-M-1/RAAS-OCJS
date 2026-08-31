num = input()
num = list(map(int, num.split()))
 
lst = []
 
for i in range(num[0]):
    
    button = input()
    button = list(map(int, button.split()))
    button.remove(button[0])
    
    for elem in button:
        if elem not in lst:
            lst.append(elem)
            
lst.sort()
 
if lst == list(range(1, num[1]+1)):
    print("YES")
else:
    print("NO")