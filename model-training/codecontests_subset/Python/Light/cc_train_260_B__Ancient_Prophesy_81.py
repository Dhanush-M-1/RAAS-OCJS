p=input()
data={}
days=[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
for i in range(len(p)-9):
    if p[i+2] == p[i+5] == "-" and (p[i+6:i+10]).isdecimal() \
            and 2013 <= int(p[i+6:i+10]) <= 2015  and p[3+i:5+i].isdecimal() and \
            1 <= int(p[i+3:i+5]) <= 12  and p[i:2+i].isdecimal() and 0 < int(p[i:2+i]) <= days[int(p[i+3:i+5])-1] :
        if p[i:i+10] in data:
            data[p[i:i+10]]+=1
        else:
            data[p[i:i+10]]=1

max_item=None
maximum=0

for i in data.keys():
    if data[i] > maximum:
        maximum = data[i]
        max_item=i


print(max_item)

