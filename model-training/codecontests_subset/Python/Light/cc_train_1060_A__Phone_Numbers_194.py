n=int(input())
list=input()
x=0
for i in range (len(list)):
    if list[i]=='8':
        x=x+1
       
print(min(n//11,x))        
