n=int(input())
s=str(input())
t=s.count('8')
if t==0:
        print(0)
else:
        k=1
        for i in range(t):
                if (n-t+i)//10>=(t-i):
                        k=0
                        print(t-i)
                        break
        if k==1:
                print(0)
                
