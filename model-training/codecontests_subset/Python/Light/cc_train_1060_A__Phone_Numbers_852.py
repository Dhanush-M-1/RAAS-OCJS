n = int(input())
s = input()
def count(str):
    k=0
    for i in str:
        if i =='8':
            k+=1
    return k
if count(s)==0:
    print(0)
else:
    if (n//11)>=count(s):
        print(count(s))
    else:
        print(n//11)
        
        

