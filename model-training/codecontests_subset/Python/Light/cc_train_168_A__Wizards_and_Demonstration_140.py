# cook your dish here

inpu = input().split()

n = int(inpu[0])
x = int(inpu[1])
y = int(inpu[2])

req = y*n/100.0

if (req != int(req)):
    req = int(req) + 1
else:
    req = int(req)

if (req <= x):
    print (0)
else:
    print (req-x)