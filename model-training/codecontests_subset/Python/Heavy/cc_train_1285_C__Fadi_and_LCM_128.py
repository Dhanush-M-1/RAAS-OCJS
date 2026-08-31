import collections, math

local = False
if local:
    file = open("inputt.txt", "r")

def inp():
    if local:
        return file.readline().rstrip()
    else:
        return input().rstrip()

def ints():
    return [int(_) for _ in inp().split()]


def gcd(a,b): 
    if a == 0: 
        return b 
    return gcd(b % a, a) 
  
def lcm(a,b): 
    return (a*b) / gcd(a,b) 

X = int(inp())

# for X in range(1, 30):
sqrtX = int(math.sqrt(X))+1

ansA, ansB = 1, X
maxAns = X

for i in range(2, sqrtX):
    if X%i==0:
        a = i
        b = X//i

        if lcm(a,b)==X:
            if max(a, b)<maxAns:
                maxAns = max(a,b)
                ansA = a
                ansB = b


print(str(ansA) + " " + str(ansB))
