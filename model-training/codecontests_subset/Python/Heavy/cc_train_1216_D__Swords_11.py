def gcd(n1,n2):
    if n2 > n1:
        return gcd(n2,n1)
    if n2 == 0:
        return n1
    return gcd(n2,n1%n2)

def check(x,arr):
    if x < max(arr):
        return float('inf'),0

    n = len(arr)
    total = sum(arr)
    g = 0
    for i in arr:
        g = gcd(g,x-i)

    y = 0
    for i in arr:
        y += (x-i)//g
    
    total = n*x-total
    if total%y != 0:
        return float('inf'),0

    return y,total//y
    
    

def main():
    n = int(input())
    arr = list(map(int,input().split()))
    y = float('inf')
    z = 0
    low = 0
    high = 10**15

    while low <= high:
        mid = low+((high-low)//2)
        y1,z1 = check(mid,arr)
        #print(mid,y1,y)
        if y1 != float('inf'):
            if y1 < y:
                y = y1
                z = z1
            high = mid-1
        else:
            low = mid+1

    print(y,z)

main()
