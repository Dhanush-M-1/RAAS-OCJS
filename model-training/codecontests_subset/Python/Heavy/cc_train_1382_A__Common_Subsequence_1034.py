import sys
input = sys.stdin.readline
 
t = int(input())
letters = 'abcdefghijklmnopqrst'
 
for _ in range(t):
    m,n = list(map(int, input().split()))
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    
    common = []
    
    for el in a:
        for kel in b:
            if el==kel:
                common.append(el)
                
                
                
    if len(common)>0:
        print('YES')
        print(1, common[0])
    else:
        print('NO')