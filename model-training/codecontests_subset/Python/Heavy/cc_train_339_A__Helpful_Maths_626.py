s = input()
a = s.split(' ')
m=[]
l=[]
f=[]
for i in a:
    m += i
    


for i in m:
    
    if i =='+':
        i=''
        
    l+=i


def buble_sort(list1):
    amount = len(list1)-1
    for i in range(0,amount):
        for x in range(0,amount):
            if list1[x] > list1[x+1]:
                list1[x],list1[x+1] = list1[x+1],list1[x]
    return list1
new_list = buble_sort(l).copy()

n=0
while n < len(new_list)-1:
    for i in new_list:
        f+=i
        f+='+'
    if len(f) > len(new_list)-1:
        break
    
    n+=1


if len(f) == 0:
    print(s)
else:
    del f[-1]
    m = ''.join(f)
    print(m)
    
        


        
    
    
