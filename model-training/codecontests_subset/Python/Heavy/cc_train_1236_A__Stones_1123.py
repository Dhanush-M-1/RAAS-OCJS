#More minor mistakes fixed, hopefully last try

t = int(input(''))
a =[]
b = []
c = []
        

for i in range(t):
    values = input('').split()
    abc = [int(x) for x in values]
    a.append(abc[0])
    b.append(abc[1])
    c.append(abc[2])
    
for i in range(t):
    maxValue = 0
    maxfromC = 0
    maxfromB = 0
    if c[i]>=2 and b[i]>=1:
        maxfromC = c[i]//2    #we first start by looking at the max we can take from the third heap
        if maxfromC >= b[i]:
            maxfromC = b[i]
        maxValue += 2*maxfromC + maxfromC   #we then add this number and add the portion we would take from heap b
    if b[i]>=2 and a[i]>=1:
        maxfromB = (b[i]-maxfromC)//2   #we subtract what we took previously and find the max we can get from the rest
        if maxfromB >= a[i]:
            maxfromB = a[i]
        maxValue += 2*maxfromB + maxfromB
    print(maxValue)
    