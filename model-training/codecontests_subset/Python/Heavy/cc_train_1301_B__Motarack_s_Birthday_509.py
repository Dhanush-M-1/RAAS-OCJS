def main():
    n=int(input())
    l=list(map(int,input().split()))
    ma=0
    mi=1000000000
    ma1=0
    
    for i in range(n):
        if(l[i]==-1):
            if((i-1)>=0 and l[i-1]!=-1):
                ma=max(ma,l[i-1])
                mi=min(mi,l[i-1])
            if((i+1)<n and l[i+1]!=-1):
                ma=max(ma,l[i+1])
                mi=min(mi,l[i+1])
    ma=(ma+mi)//2
    ans=0
    for i in range(n):
        if(l[i]==-1):
            l[i]=ma
        if(i):
            ans=max(ans,abs(l[i]-l[i-1]))
    print(ans,ma)
        
        
    
    
            
if __name__ == '__main__':
    t=int(input())
    for _ in range(t):
        main()
