def two_gram(n,s):
    a = s[0:2]
    maior = 0
    menor = 0
    for i in range(0,len(s)-1):
        #print(f'agora estou comparando {s[i:i+2]}')
        for j in range(i+1,len(s)-1):
            if s[i:i+2] == s[j:j+2]:
                #print(f'achei um valor igual a {s[j:j+2]}')
                menor += 1
                #print(menor)

        if maior < menor:

            #print(maior,menor,s[i:i+2])
            maior = menor
            a = s[i:i+2]
            #print(f'a esta valendo {s[i:i+2]}')
        menor = 0





    return a

a = int(input())
b = str(input())
print(two_gram(a,b))