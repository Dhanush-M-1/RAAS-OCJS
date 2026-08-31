def fun():
    a,b=map(int,input().split())
    cnt=0
    while cnt<a:
        cnt+=1
        if cnt%b==0:
            a+=1
    print(a)
            
    
    
fun()