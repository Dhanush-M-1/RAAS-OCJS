n = int(input())

numbers = input().split(" ")

par = []
impar = []

for i in range(n):
    if(int(numbers[i]) % 2 == 0):
        par.append(int(numbers[i]))
    else:
        impar.append(int(numbers[i]))

par.sort()
impar.sort()

while(True):

    if(len(par) == len(impar) or len(par) + 1 == len(impar) or len(impar) + 1 == len(par)):
        print(0)
        break

    elif(len(impar) > len(par)):
        for i in range(len(par) + 1):
            impar.pop()
        print(sum(impar))
        break
    elif(len(par) > len(impar)):
        for i in range(len(impar) + 1):
            par.pop()
        print(sum(par))
        break
        
 



