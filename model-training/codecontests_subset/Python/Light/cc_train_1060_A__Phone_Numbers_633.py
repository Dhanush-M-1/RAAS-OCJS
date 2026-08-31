n=int(input())
s=input()
k=0
if('8' in s):
    d=s.count('8')
    if(d>=1):
        while(n>=11 and d>0):
            k+=1 
            d-=1
            n-=11
print(k)
