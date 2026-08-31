
x = input()
no_of_digits = len(x)
ilst = list()
index=0
for i in x:
    if i=='+':
       ilst.append(index)
    index=index+1

count = 0
lst = list()
try:
 for i in range(len(ilst)):
    try:
      y = x[ilst[i]+1:ilst[i+1]]
    except:
      y = x[ilst[i]+1:]
    y = int(y)
    lst.append(y)


 fst = int(x[:ilst[0]])
 lst.append(fst)
 new_lst = list() 
 for i in range(len(lst)):
    new =  min(lst)
    new_lst.append(new)
    lst.remove(new)
 result = str(new_lst[0])
 for i in new_lst[1:]:
    result = result +  "+" + str(i)

 print(result)
    


except:
    print(x)
