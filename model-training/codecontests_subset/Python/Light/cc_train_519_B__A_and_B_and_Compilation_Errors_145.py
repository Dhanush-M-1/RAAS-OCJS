
def Com_error(a,b):
    a.sort()
    b.sort()
    i = 0
   
    while i < len(b):
        if a[i] != b[i]:
            return a[i]

        i = i + 1    
            
    return a[-1]


n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]
print(Com_error(a,b))
print(Com_error(b,c))