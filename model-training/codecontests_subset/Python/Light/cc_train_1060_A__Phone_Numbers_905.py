n=int(input())
m=input()
p=0

for i in range (len(m)):
    if m[i]=='8' and n>=(p+1)*11:
        p=p+1
    else:
        p=p

print(p)

