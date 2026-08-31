import sys
import io, os
def main():
    input=sys.stdin.readline
    t=int(input())
    for i in range(t):
        n,l,r=map(int,input().split())
        end=[]
        start=(n-1)*2
        copy=0
        count,ok=0,True
        for i in range(1,n+1):
            if (count+start)<l:
                count+=start
                copy+=start
                start-=2
            else:
                pq=count
                for j in range(i+1,n+1):
                    end.append(i)
                    end.append(j)
                    pq+=2
                    count=pq
                    if pq>=r:
                        ok=False
                        break
            if ok==False:
                break
        if r==n*(n-1)+1:
            end.append(1)
        #print(end,copy)
        ans=' '.join(map(str,end[l-copy-1:r-copy]))
        sys.stdout.write(ans+'\n')
        
        
                  

            
if __name__ == "__main__": 
    main() 


        
 

