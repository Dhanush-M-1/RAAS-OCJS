a=int(input())
l=input().split()
list1= input().split()
list2= input().split()
save=[]
def notThere(base,check):
    base.sort()
    check.sort()
    for i in range(0,len(check)):
        if(base[i]!=check[i]):
            return base[i]
    return base[len(base)-1]

a=0
b=0
a=notThere(l,list1)
b=notThere(list1,list2)
        
print(a)
print(b)