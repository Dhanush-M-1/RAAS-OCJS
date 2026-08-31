def solve():
    N = int(input())
    
    A = [int(k) for k in input().split()]
    A.sort()
    
    even = []
    odd = []
    
    for i in range(N):
        if A[i] % 2:
            odd.append(A[i])
        else:
            even.append(A[i])

    if len(odd) > len(even):    
        while True:
            odd.pop()
    
            if even:
                even.pop()
            else:
                break
    else:    
        while True:
            if even:
                even.pop()
            else:
                break
    
            if odd:
                odd.pop()
            else:
                break
            
    print (sum(odd) + sum(even))
        
if __name__ == "__main__":
    solve()