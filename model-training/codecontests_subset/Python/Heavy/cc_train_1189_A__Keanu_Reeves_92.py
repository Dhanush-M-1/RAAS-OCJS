# 1189A Киану Ривз
def sum(nn,l):
    num0=0
    num1=0    
    for i in range(nn):        
        if l[i]=='0':
            num0+=1
        if l[i]=='1':
            num1+=1
    #print('Функция sum : num0=',num0,' num1=',num1)
    if num0==num1:
        return 'true'
    else:
        return 'false'
#    
n=int(input())
s=input()
#print(n)
#print(s)
#print(len(s))
l=list(s)
#print(l)
if n%2!=0: #Нечётное число 0 и 1 - выводим без изменений   
    print(1)
    print(s)
    raise SystemExit
if n==2 and s=='01':
    print(2)
    print('0 1')
elif n==2 and s=='10':
    print(2)
    print('1 0')
elif n==2:
    print(1)
    print(s)
#print(sum(n,l))
else:
    # Чётное число 0 и 1
    if(sum(n,l)=='true'): # Проверяем равенство 0 и 1
        print(2)
        print(s[0],s[1:])
    else:
        print(1)
        print(s)

    
