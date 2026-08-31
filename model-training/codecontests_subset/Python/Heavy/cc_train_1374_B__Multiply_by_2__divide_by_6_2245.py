t=int(input())
for _ in range(t):
    a=int(input())
    temp1=a
    temp2=a
    count1=0
    count2=0
    while temp1%2==0:
        temp1=temp1//2
        count1+=1
    while temp2%3==0:
        temp2=temp2//3
        count2+=1
    if count1>count2:
        print(-1)
        continue
    stepcount=(count2-count1)*2
    a=a//(3**(count2-count1))
    count1=0
    c=0
    while a>1:
        if a%6==0:
            count1+=1
            a=a//6
        elif a!=1:
            c=1
            break

    if c==1:
        print(-1)
        continue
    stepcount=stepcount+count1
    print(stepcount)