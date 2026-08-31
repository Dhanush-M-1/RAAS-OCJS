# coding: utf-8
def q1():
    while 1:
        count=0
        n=int(input())
        if(n==0):
            break
        data=input().split()
        f=False
        ft=[False,False]
        for order in data:
            if order[0]=='l':
                x=0
            else:
                x=1
            if order[1]=='u':
                y=True
            else:
                y=False
            ft[x]=y
            if ft[0]==ft[1]==True and f==False:
                f=True
                count+=1
            elif ft[0]==ft[1]==False and f==True:
                f=False
                count+=1
        print(count)
                
question = [q1]

question[0]()
