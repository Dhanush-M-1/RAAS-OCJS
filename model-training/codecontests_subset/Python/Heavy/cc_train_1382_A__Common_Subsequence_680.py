t=int(input())
for i in range(t):
    m,n = map(int, input().strip().split(' '))
    a = list(map(int, input().strip().split(' ')))
    b = list(map(int, input().strip().split(' ')))
    f=0
    if len(a)>len(b):
        for j in range(len(b)):
            if b[j] in a:
                f=1
                print("YES")
                print(1,b[j],end=" ")
                print()
                break
    else:
        for j in range(len(a)):
            if a[j] in b:
                f=1
                print("YES")
                print(1,a[j],end=" ")
                print()
                break
    if f==0:
        print("NO")
        
                
            