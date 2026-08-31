# cook your dish here
import sys

for _ in range(int(input())):
    n, m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    
    check = [0 for i in range(n+1)]
        
    for i in range(m):
        check[0]+= 1
        check[p[i]]-=1
    
    check[0]+=1
    check[n]-=1
        
    for i in range(1, n):
        check[i] = check[i]+check[i-1]
        
    ans = [0 for _ in range(26)]
    
    for i in range(n):
        ans[ord(s[i])-ord('a')]+=check[i]
        
    for i in range(26):
        print(ans[i], end=" ")
    print()
        
        
        
    