victims = list(map(str, input().strip().split(" ")))

n = int(input())

print(victims[0], victims[1])
for i in range(n):
    aux = list(map(str, input().strip().split(" ")))
    
    if(aux[0] == victims[0]):
        victims[0] = aux[1]
    elif aux[0] == victims[1]:
        victims[1] = aux[1]
        
    print(victims[0], victims[1])
    