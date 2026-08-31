import sys
#q=1
q=int(input())
for i in range(q):
    n,m=[int(j) for j in sys.stdin.readline().split()]
    #n=int(sys.stdin.readline())
    a=[int(j) for j in sys.stdin.readline().split()]
    #a=input()
    b=[int(j) for j in sys.stdin.readline().split()]
    for i in range(n):
        flag=0
        for j in range(m):
            if a[i]==b[j]:
                print('YES')
                print(1, a[i])
                flag=1
                break
        if flag==1:
            break
    else:
        print('NO')
    
            

    
    
    
    
