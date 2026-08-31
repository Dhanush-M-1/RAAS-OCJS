if __name__ =='__main__':
    t=int(input())
    for i in range(0,t):
        val=int(input())
        if val%2==0 and val%6!=0:
            print(-1)
        else:
            if val==1:
                print(0)
            else:
                count=0
                while val>1:
                    if val%6==0 and val!=2:
                        val=val/6
                    elif val==2:
                        count=-1
                        break
                    else:
                        if val%3==0:
                            val=val*2
                        else:
                            count=-1
                            break
                    count=count+1
                print(count)