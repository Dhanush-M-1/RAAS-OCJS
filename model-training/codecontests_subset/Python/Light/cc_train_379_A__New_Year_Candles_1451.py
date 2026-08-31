a,b = [int(i) for i in input().split()]

total = a
old = a

while old>=b:
    new = old//b
    old -= new*b
    total += new
    old += new
    new = 0

print(total)