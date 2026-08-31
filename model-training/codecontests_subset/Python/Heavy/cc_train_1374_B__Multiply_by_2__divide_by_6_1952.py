import math
def gcd(a,b): 
    if (b == 0): 
         return a 
    return gcd(b, a%b) 

def lcm(a,b): 
    return (a*b) / gcd(a,b) 

def bs(arr, l, r, x): 
    while l <= r: 
        mid = l + (r - l)//2; 
        if(arr[mid]==x): 
            return arr[mid]
        elif(arr[mid]<x): 
            l = mid + 1
        else: 
            r = mid - 1
    return -1

def swap(list, pos1, pos2): 
      
    list[pos1], list[pos2] = list[pos2], list[pos1] 
    return list

t = int(input())
for _ in range(t):
    n = int(input())
    x = n/3
    if(n==1):
        print(0)
        continue
    # print(x,y)
    if(n==3):
        print(2)
    elif(x%1!=0):
        print(-1)
    else:
        i3 = 0
        nn = n
        while(nn%3==0):
            nn=nn/3
            i3+=1
        i2 = 0
        while(nn%2==0):
            nn=nn/2
            i2+=1
        # print(i3,i2)
        if(i3>=i2):
            z = n*pow(2,i3-i2)
            x = 0
            while(z%6==0):
                z=z/6
                x+=1
            if(z!=1):
                print(-1)
            else:
                print(i3-i2+x)
        else:
            print(-1)