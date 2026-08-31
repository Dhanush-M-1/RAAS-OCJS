def f():
    n = int(input())
    a = [int(i)for i in input().split()]    
    for i in range(2,n):
        if a[0]+a[1]<=a[i]:
            print(1,2,i+1)
            return 
    print(-1)        
for _ in range(int(input())):
    f()