a,b = [int(i) for i in input().split()]
def calc(a,b,count = 0) :
    if a<b and a>=0:
        count += a
        return count
    elif a>=0:
        return calc(a-b +1, b,count) + b
        
print(calc(a, b,count = 0))