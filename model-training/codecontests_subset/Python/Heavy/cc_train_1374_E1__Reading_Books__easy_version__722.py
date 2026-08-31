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

t = 1
for _ in range(t):
    n,k = map(int,input().split())
    x = []
    c=0
    ans=0
    y01 = []
    y10 = []
    y11 = []
    for i in range(n):
        tt,a,b = map(int,input().split())
        if(a==1 and b==1):
            y11.append(tt)
        elif(a==1 and b==0):
            y10.append(tt)
        elif(a==0 and b==1):
            y01.append(tt)
    y11.sort()
    y01.sort()
    y10.sort()
    f=0
    i = 0
    j = 0
    while(k):
        k-=1
        if(i<len(y11) and (j<len(y01) and j<len(y10))):
            if(y11[i]<y01[j]+y10[j]):
                ans+=y11[i]
                i+=1
            else:
                ans+=y10[j]+y01[j]
                j+=1
        elif(i<len(y11)):
            ans+=y11[i]
            i+=1
        elif((j<len(y01) and j<len(y10))):
            ans+=y10[j]+y01[j]
            j+=1
        else:
            f=1

    if(f):
        print(-1)
        continue
    print(ans)
