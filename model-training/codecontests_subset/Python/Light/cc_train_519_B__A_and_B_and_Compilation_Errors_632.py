n=input()
l1=input()
l2=input()
l3=input()

def sum(l):
    s = 0
    l=l.split(' ')
    for i in l:
        s+=int(i)
    
    return s

print(sum(l1)-sum(l2))
print(sum(l2)-sum(l3))