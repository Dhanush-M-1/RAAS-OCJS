def checkinvalidity(a, b, c):  
 
    if (a + b <= c) or (a + c <= b) or (b + c <= a) : 
        return True
    else: 
        return False

for _ in range(int(input())):
    count=0 
    n= int(input())
    arr= list(map(int,input().split()))

    for i in range(n-2):
        a=arr[i]
        b=arr[i+1]
        c=arr[n-i-1]
        
        if(checkinvalidity(a,b,c)):
            print(i+1,i+2,n-i)
            count+=1
            break
    if(count==0):
        print(-1)
