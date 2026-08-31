l=[int(input()) for i in range(int(input()))]
def verify(x):
    n=0
    m=0
    while x!=1:
        if x%6==0:
            x=x//6
            n+=1
            m=0
        else:
            if x<6 and x!=3:
                print(-1)
                break
            else:
                if m<=3:
                    x=2*x
                    n+=1
                    m+=1
                else:
                    print(-1)
                    break
    else:
        print(n)
for i in l:
    verify(i)