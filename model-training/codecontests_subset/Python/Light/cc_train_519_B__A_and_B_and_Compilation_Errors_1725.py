n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))
a.sort()
b.sort()
c.sort()

check1 = 0
check2 = 0
    
for i in range(n - 1):
    if(b[i] != a[i]):
        print(a[i])
        check1 = 1
        break
if(check1 == 0):
    print(a[n-1])
for i in range(n - 2):
    if(c[i] != b[i]):
        check2 = 1
        print(b[i])
        break

if(check2 == 0):
    print(b[n - 2])




    

