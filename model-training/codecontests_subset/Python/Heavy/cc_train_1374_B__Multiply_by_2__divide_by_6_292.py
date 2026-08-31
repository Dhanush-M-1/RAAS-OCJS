
def solution1():
    for tangocharlie in range(int(input())):
        xx,yy,nn=map(int,input().split())
        p=nn//xx
        k=(p*xx)+yy
        while k>nn:
            p-=1
            k=(p*xx)+yy
        print(k)



def solution2():
    for tangocharlie in range(int(input())):
        nnn=int(input())
        apple=5
        banana=10
        orange=apple+banana
        answer=0
        while nnn>1:
            if nnn%6==0:
                answer+=1
                nnn=nnn//6
            elif nnn%3==0 and nnn%2!=0:
                answer+=1
                nnn*=2
            else:
                answer=-1
                break
        print(answer)


def solution3():
    for tangocharlie in range(int(input())):
        number=int(input())
        sunlight=list(input())
        opnn=wrong=0
        for i in sunlight:
            if i=='(':
                opnn+=1
            else:
                opnn-=1
            
            if opnn<0:
                wrong+=1
                opnn=0
        
        print(wrong)



def solution4():
    for tangocharlie in range(int(input())):
        n,k=map(int,input().split())
        abra_ka_dabra=sorted(list(map(int,input().split())))
        abra_ka_dabra1=[]
        for i in abra_ka_dabra:
            if i%k!=0:
                abra_ka_dabra1.append(k-(i%k))
        if len(abra_ka_dabra1)==0:
            print(0)
            continue
        abra_ka_dabra1.sort()     
        ans=abra_ka_dabra1[0]
        curr=abra_ka_dabra1[0]
        
        for i in range(1,len(abra_ka_dabra1)):
            if abra_ka_dabra1[i]!=abra_ka_dabra1[i-1]:
                curr=abra_ka_dabra1[i]
            else:
                curr+=k
            ans=max(ans,curr)
     
        print(ans+1)
solution2()