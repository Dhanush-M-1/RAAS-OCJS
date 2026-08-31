counter=int(input())
i=0
data=[]
while i <counter:
    data.append(int(input()))
    i+=1
for i in data:
    if i==1:
        print("0")
        continue
    if i==2:
        print("-1")
        continue
    counter=0
    if (i%6!=0) and (i%3!=0):
            print("-1")
            continue
    while True :
        if (i%6!=0) and (i%3==0):
            i*=2
            counter+=1
            continue
        elif i%6==0:
            i=i/6
            counter+=1
            continue
        elif i==1:
            print(counter)
            break
        elif (i%6!=0) and (i%3!=0):
            print("-1")
            break

            
            
        
