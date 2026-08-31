line=input()
a=0
b=0
c=0
def ex():
    print("".join(result)) 
    quit()  
result=list()
l=int(len(line)/2+1)
for i in range(l):
    if line[int(2*i)]=="1":
        a=a+1
    elif line[2*i]=="2":
        b=b+1
    else:
        c=c+1
count=a+b+c
for i in range(a):
    count=count-1
    result.append("1")
    if count==0:
        ex() 
    result.append("+") 
for i in range(b):
    count=count-1
    result.append("2")
    if count==0:
        ex()  
    result.append("+")
for i in range(c):
    count=count-1
    result.append("3")
    if count==0: 
        ex()
    result.append("+")   
print(a,b,c) 