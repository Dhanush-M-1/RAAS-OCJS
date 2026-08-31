t=int(input())

l=[]
for i in range(0,t):
    n=int(input())
    s=input()
    l=s.split()       
    if int(l[0])+int(l[1])>int(l[-1]):
        print(-1)
        
    else:
        print(1,2,n)
