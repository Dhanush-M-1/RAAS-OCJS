def verify_result(k , arr):
    for i in arr:
        if i == 0:
            k+=1
        else:
            if k >= i:
                continue
            else:
                return [-1]
    
    return arr

def solve():
    input()
    k,n,m = list(map(int , input().split()))
    a = list(map(int , input().split()))
    b = list(map(int , input().split()))

    p1 = 0;
    p2 = 0;
    result = []
    while p1<n or p2<m:
        value_1 = float('inf')
        value_2 = float('inf')
        
        if p1<n:
            value_1 = a[p1]
            if value_1 == 0:
                result.append(value_1)
                p1 += 1
                continue
        if p2<m:
            value_2 = b[p2]
            if value_2 == 0:
                result.append(value_2)
                p2 += 1
                continue
        
        if value_1 < value_2:
            result.append(value_1)
            p1+=1
            continue
        
        else:
            result.append(value_2)
            p2 += 1
            continue
        
    print( *verify_result(k , result)  , sep = ' ')

          
    
for i in range(int(input())):
    
    solve()