def main():
    t=int(input())
    for i in range(t):
        x=int(input())
        t=0
        flag=1
        while x!=1:
            if(x%3==0):
                if(x%2==0):
                    x=x//6
                    t+=1
                else:
                    x=x*2
                    t+=1
                    flag=1
            else:
                flag=0
                break
        if flag==0:
            print('-1')
        else:
            print(t)
if __name__=='__main__':
    main()