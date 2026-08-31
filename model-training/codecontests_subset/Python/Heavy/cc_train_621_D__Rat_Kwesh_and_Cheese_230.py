import math
inp = input().split()
x = float(inp[0])
y = float(inp[1])
z = float(inp[2])
arr = [[x, y, z], [x, z, y], [x, y*z, 1], [x,z*y, 1], [y, x,z], [y, z,x], [y,x* z, 1], [y,z*x, 1], [z, x, y], [z, y, x], [z, x* y, 1], [z,y* x, 1]]
idd = 0
def comp(a, b): # tak to odrbem lol
    if(len(a) == 3 and len(b) == 3):
        an1 = math.log(a[0])
        an2 = math.log(b[0])
        if(an1 < 0 and an2 >= 0):
            return False
        elif(an1 >= 0 and an2 <0):
            return True
        swapped = False
        if(an1 < 0 and an2 < 0):
            an1 = -an1
            an2 = -an2
            swapped = True
        if(a[0] == 0 and b[0] == 0):
            return False
        if(a[0] == 1):
            return math.log(b[0]) < 0
        if(b[0] == 1):
            return math.log(a[0]) > 0
        ans1 = a[2] * math.log(a[1]) + math.log(an1)
        ans2 = b[2] * math.log(b[1]) + math.log(an2)
        if(swapped):
            return ans1 < ans2
        else:
            return ans1 > ans2

        
        
for i in range(len(arr)):
    if(comp(arr[i], arr[idd])):
        idd = i
    
if(idd == 0):
    print("x^y^z")
elif(idd == 1):
    print("x^z^y")
elif(idd == 2):
    print("(x^y)^z")
elif(idd == 3):
    print("(x^z)^y")
elif(idd == 4):
    print("y^x^z")
elif(idd == 5):
    print("y^z^x")
elif(idd == 6):
    print("(y^x)^z")
elif(idd == 7):
    print("(y^z)^x")
elif(idd == 8):
    print("z^x^y")
elif(idd == 9):
    print("z^y^x")
elif(idd == 10):
    print("(z^x)^y")
elif(idd == 11):
    print("(z^y)^x")


