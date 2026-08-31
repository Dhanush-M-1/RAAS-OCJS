n = int(input())
l = 0
r = 0
c = 2
ll = []
for i in range(n):
    x,h = map(int,input().split())
    ll.append([x,h])
for i in range(1,n-1):
    if ll[i][0]-ll[i][1]>ll[i-1][0]:
        if l!=1:
            c+=1
            r = 1
        else:
            if ll[i-1][0] + ll[i-1][1]<ll[i][0]-ll[i][1]:
                c+=1
                r = 1
                l = 0
            else:
                if ll[i+1][0]>ll[i][0] + ll[i][1]:
                    c+=1
                    r = 0
                    l = 1
                else:
                    l = 0
                    r = 1
    else:
        if ll[i+1][0]>ll[i][0] + ll[i][1]:
            c+=1
            r = 0
            l = 1
        else:
            l = 0
            r = 1
if n == 1:
    print(1)
else:
    print(c)
                
                
                
        
    
    
