s=input()
one=two=three=0
new_string=''
zifra=0
for i in range(len(s)):
    if s[i]=='1':
        one+=1
        zifra+=1
    elif s[i]=='2':
        two+=1
        zifra+=1
    elif s[i]=='3':
        three+=1
        zifra+=1


for j in range(one):
    new_string+='1'
    if zifra!=1:
        new_string+='+'
    zifra-=1
for j in range(two):
    new_string+='2'
    if zifra!=1:
        new_string+='+'
    zifra-=1
for j in range(three):
    new_string+='3'
    if zifra!=1:
        new_string+='+'
    zifra-=1
print(new_string)
