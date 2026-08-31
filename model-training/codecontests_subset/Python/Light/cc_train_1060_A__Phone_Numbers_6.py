n=int(input())
s=input()
i=0
nb_8=0
if n>10:
    
    while(i<n)&((n-(nb_8*11))>10):
        if s[i]=='8':
            nb_8+=1
        i+=1
print(nb_8)