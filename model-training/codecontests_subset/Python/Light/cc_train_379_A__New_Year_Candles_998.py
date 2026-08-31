n,t=map(int,input().split())
tt=0
while n>=t:
    n=n-t+1
    tt+=1
print((tt*t)+n) 