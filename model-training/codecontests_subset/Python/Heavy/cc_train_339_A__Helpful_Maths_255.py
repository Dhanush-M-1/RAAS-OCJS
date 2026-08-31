def stringtonum(string):
    i=0
    number=[]
    array1=[]
    array=[]
    string= string+"+"
    while i<len(string):
        if string[i]!="+":
            number.append(string[i])
        else:
            array.append(number)
            number=[]
        i=i+1
    j=0
    while j<len(array):
        k=0
        s=""
        while k<len(array[j]):
            s=s+array[j][k]
            k=k+1
        s=int(s)
        array1.append(s)
        j=j+1
    l=0
    return(array1)
s=input()
result=stringtonum(s)
i=0
o=0
tw=0
th=0
while i<len(result):
    if result[i]==1:
        o=o+1
    elif result[i]==2:
        tw=tw+1
    elif result[i]==3:
        th=th+1
    i=i+1
final=[]
i=0
j=0
k=0
while i<o:
    final.append("1")
    i=i+1
while j<tw:
    final.append("2")
    j=j+1
while k<th:
    final.append("3")
    k=k+1
l=0
s="+".join(final)
print(s)