def main():
    t=int(input())
    cnt=0
    found=1
    while(t>0):
        n=int(input())
        if(n==1):
            print("0")
        else:
            while(n!=1):
                if(n%6==0):
                    n=n//6
                    cnt=cnt+1
                elif(n%3==0):
                    n=n*2
                    cnt=cnt+1
                elif(n==2):
                    found=0
                    break
                elif(n%6!=0 and n%3!=0):
                    found=0
                    break
            if(found==0):
                print("-1")
            else:
                print(cnt)
        cnt=0
        found=1
        t-=1
main()
                    
                    
                
                