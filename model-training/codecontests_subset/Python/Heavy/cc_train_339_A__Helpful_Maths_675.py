import math

def merge_sort(x):
    if len(x) == 1:
        return x
        
    left = []
    right = []
    
    for i in range(0, len(x)):
        if i < len(x)/2:
            left.append(x[i])
        else:
            right.append(x[i])
            
    left = merge_sort(left)
    right = merge_sort(right)
    
    return merge(left, right)
    
def merge(left, right):
    sol = []
    
    while len(left) > 0 and len(right) > 0:
        if left[0] <= right[0]:
            sol.append(left[0])
            left = left[1:]
        else:
            sol.append(right[0])
            right = right[1:]
            
    while len(left) > 0:
        sol.append(left[0])
        left = left[1:]
    while len(right) > 0:
        sol.append(right[0])
        right = right[1:]
        
    return sol

string = input()

numberstring = []

for i in range(0, math.ceil(len(string)/2)):
    numberstring.append(int(string[2*i]))
    
sort = merge_sort(numberstring)

sol = str(sort[0])

for i in range(1, len(sort)):
    sol = sol + '+' + str(sort[i])
    
print(sol)