# cook your dish here
t=int(input())
for i in range(t):
    l,r,d=map(int,input().split(' '))
    if l/d<=1:
        x=int(r/d)
        print((x+1)*d)
    else:
        print(d)
    
        
    