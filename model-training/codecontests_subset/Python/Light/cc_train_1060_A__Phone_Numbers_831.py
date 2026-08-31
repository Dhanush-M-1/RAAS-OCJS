def calculnb_8(s,n):
    nb_8=0
    for i in range(n):
        if s[i]=='8':
            nb_8+=1
    return nb_8
            
n=int(input())
s=input()
i=0
if n>10:
    nb_8=calculnb_8(s,n)
    while(i<nb_8)&((n-(i*11))>10):
        i+=1
print(i)
    
    

