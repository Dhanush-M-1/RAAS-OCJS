password = str(input())

n = int(input())
first = False
second = False

for i in range(n):
    a = str(input())

    if(a==password):
        print("YES")
        first=True
        second=True
        break
    
    if(a[1]==password[0]):
        first = True
        
    if(a[0]==password[1]):
        second = True

    if(first==True):
        if(second==True):
            print("YES")
            break
        
if(first==False):
    print("NO")

elif(second==False):
        print("NO")

