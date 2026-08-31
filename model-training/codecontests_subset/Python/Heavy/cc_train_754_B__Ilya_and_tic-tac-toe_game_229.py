def check1(data, arr):
    l = [data[i][k] for i,k in arr]
    return sum(map(lambda x: x == '.', l)) == 1 and sum(map(lambda x: x == 'x', l)) == 2

def check2(data, arr):
    return any([check1(data, a) for a in arr])

def generate1(i, j):
    return [(i+z, j) for z in range(3)]
def generate2(i, j):
    return [(i, j+z) for z in range(3)]
def generate3(i, j):
    return [(i+z, j+z) for z in range(3)]
def generate4(i, j):
    return [(i+z, j-z) for z in range(3)]
    
def check(data):
    l1 = [generate1(i,j) for i in range(2) for j in range(4)]    
    l2 = [generate2(i,j) for i in range(4) for j in range(2)]
    l3 = [generate3(i,j) for i in range(2) for j in range(2)]
    l4 = [generate4(i,j) for i in range(2) for j in range(2,4)]    
    return check2(data, l1) or check2(data, l2) or check2(data, l3) or check2(data, l4)
    
data = [input() for i in range(4)]
if check(data):
    print("YES")
else:
    print("NO")
    