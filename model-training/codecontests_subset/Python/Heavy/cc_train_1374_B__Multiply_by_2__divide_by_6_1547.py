for _ in range(int(input())):
    x=int(input())
    if(x==1):
        print("0")
    else:
        if(x%3==0):
            r=x
            tp=0
            while(r%3==0):
                tp+=1
                r=r//3
            ev=0
            while (r % 2 == 0):
                ev += 1
                r = r // 2
            if(tp<ev or r!=1):
                print("-1")
            elif(tp==ev):
                print(tp)
            else:
                ev=tp-ev
                print(ev+tp)
        else:
            print("-1")