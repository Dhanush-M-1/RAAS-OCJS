a,b=map(int,input().split())
count=0
d=0
while a>=b:
    a=a-b
    count+=1
    a+=1
print(count*b+a)


    #a=a-1
    #count+=1
    #d+=1
    #if a%b==0:
        #d+=1
