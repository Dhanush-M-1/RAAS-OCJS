import math
st=''

def func(a,b):
    c=1
    s=0
    cana,canb=a,0
    while cana:
        s+=cana
        canb+=cana
        cana=canb//b
        canb=canb%b

    return s










for _ in range(1):#int(input())):
    a,b=map(int,input().split())
    #n = int(input())
    #l1=[]
    #inp=input().split()
    #s=input()
    #l1=list(map(int,input().split()))
    #l2 = list(map(int, input().split()))
    #l1=input().split()
    #l2=input().split()
    st+=str(func(a,b))+'\n'

print(st)