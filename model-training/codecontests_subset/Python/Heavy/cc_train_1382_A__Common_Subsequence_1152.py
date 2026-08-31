t = int(input())

def solve(a,b):
    found = False
    ans = -1
    for i in range(len(a)):
        for j in range(len(b)):
            if a[i] == b[j]:
                found = True
                ans = a[i]
                break
        if found:
            break
    return ans
    

while t > 0:
    # n = int(input())
    # s = input()
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    
    ans = solve(a,b)
    
    if ans != -1:
        print("YES")
        print(1,ans)
    else:
        print("NO")
    
    
    t -= 1