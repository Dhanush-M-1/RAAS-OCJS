t=int(input())
while (t>0):
    t=t-1
    k=0
    n=int(input())
    if (n==1):
        print("0")
    else:
        if (n%3==0):
            while (n>1):
                if (n%3==0):
                    
                    if (n%6==0):
                        k+=1
                        n=n//6
                    else:
                        n=n*2
                        k+=1
                    if (n==1):
                        break
                else:
                    k=-1
                    break
            print(k)
        else:
            print("-1")