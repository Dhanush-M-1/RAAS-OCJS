inp=str(input())
inp1=inp.split()
a=int(inp1[0])
b=int(inp1[1])
count=0
i=a
r=0
while(i>0):
    count+=i
    e=i//b
    r+=i%b
    if(r//b>0):
        e+=r//b
        r%=b
    i=e
print(count)
    
    
