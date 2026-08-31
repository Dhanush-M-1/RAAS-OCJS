a,b=[int(x) for x in input().split()]

res = 0
burnt = 0
while a>0:
    burnt+=a
    res+=a
    a=burnt//b
    burnt = burnt%b
print(res)