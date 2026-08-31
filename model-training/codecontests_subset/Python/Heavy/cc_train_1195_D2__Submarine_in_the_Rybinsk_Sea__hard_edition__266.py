n=int(input())
sum=0
line=input().split()
freq=[] # para guardar en la posición i la cantidad de números con la cantidad de cifras igual a i 
for i in range(0, 11):
    freq.append(0)
for item in line:
    freq[len(item)]+=1 
def solve1(str, l): # Calcula la contribució str con respecto a un número de l cantidad de cifras cuando f(srt,x) donde x
    n=len(str)      # es un número con cantidad de cifras igual a l
    i=0
    s=""
    if n>=l:
        s=str[0:n-l]
        i=n-l
    for k in range(i, n):
        s=s+str[k]+"0"
    return s  
def solve2(str, l): # Calcula la contribució str con respecto a un número de l cantidad de cifras cuando f(x, srt) donde x 
    n=len(str)       # es un número con cantidad de cifras igual a l
    i=0
    s=""
    if n>=l:
        s=str[0:n-l]
        i=n-l
    for k in range(i, n):
        s=s+"0"+str[k]
    return s
for i in range(0,n):
    for l in range(1, 11):
        if freq[l]!=0:
            temp1=solve1(line[i], l)  # Se calcula la contribución de cada número , respecto a  la cantidad de cifras de 
            temp2=solve2(line[i], l)  # cifras que tienen los números de la matriz
            sum=sum + (int(temp1)+int(temp2))*freq[l] 
            sum%=998244353
print(sum)