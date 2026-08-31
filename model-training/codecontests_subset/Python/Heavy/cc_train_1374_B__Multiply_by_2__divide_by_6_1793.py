def count_three(t):
    count=0
    while(t%3==0):
        t=t/3
        count+=1
    return count
def count_two(t):
    count=0
    while(t%2==0):
        t=t/2
        count+=1
    return count
if __name__ =="__main__":
    num = int(input())
    res=0
    for i in range (0,num):
        t=int(input())
        if(t==1):
            res=0
        elif (t%3!=0):
            res=-1
        else:
            ct3=count_three(t)
            ct2=count_two(t)
            if (ct2>ct3):
                res=-1
            else:
                n=2*ct3-ct2
                if (t*pow(2,ct3-ct2)==pow(6,ct3)):
                    res=n
                else:
                    res=-1
        print(res)
