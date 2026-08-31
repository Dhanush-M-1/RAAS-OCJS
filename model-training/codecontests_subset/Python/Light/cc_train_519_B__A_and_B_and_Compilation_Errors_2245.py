def myfun():
    n=int(input())
    sum2=0
    k=input()
    k=k.split(" ")
    for i in range(n):
        sum2=sum2+int(k[i])
    sum1=0;
    k=input()
    k=k.split(" ")
    for i in range(n-1):
        sum2=sum2-int(k[i])
        sum1=sum1+int(k[i])
    sum3=0;
    k=input()
    k=k.split()
    for i in range(n-2):
         sum1=sum1-int(k[i])
    print(sum2)
    print(sum1)
    
myfun()

        
