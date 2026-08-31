x=input().split('+')
counter1=0
counter2=0
counter3=0
counter=len(x)
for i in range(len(x)):
    if int(x[i])==1:
        counter1+=1
    elif int(x[i])==2:
        counter2+=1
    elif int(x[i])==3:
        counter3+=1

for i in range(counter1):
    if counter==1:
        print('1')
    else:
        print('1', end='+')
        counter-=1
for i in range(counter2):
    if counter==1:
        print('2')
    else:
        print('2', end='+')
        counter-=1
for i in range(counter3):
    if counter==1:
        print('3')
    else:
        print('3', end='+')
        counter-=1

