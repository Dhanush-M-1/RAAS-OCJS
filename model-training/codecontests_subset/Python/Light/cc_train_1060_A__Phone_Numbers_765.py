n=int(input())
d=0
m=str(input())
for i in m:
    if (int(i)==8):
        d=d+1
print(min(d,int(n/11)))        
