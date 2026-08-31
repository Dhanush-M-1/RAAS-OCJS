st = input()
numbers=st.split("+")
one=[]
two=[]
three=[]
order=""
for i in numbers:
    if int(i)==1:
        one.append(i)
    elif int(i)==2:
        two.append(i)
    elif int(i)==3:
        three.append(i)

for j in one:
    if order == "":
        order = order+j
    else:
        order= order + "+" + j
for s in two:
    if order == "":
        order = order+s
    else:
        order= order + "+" + s
for t in three:
    if order == "":
        order = order+t
    else:
        order= order + "+" + t
print(order)
