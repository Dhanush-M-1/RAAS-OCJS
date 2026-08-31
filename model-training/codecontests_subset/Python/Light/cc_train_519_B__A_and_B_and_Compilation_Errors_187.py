N = int(input()) 
L = list(map(int, input().split())) 
M = list(map(int, input().split()))
K = list(map(int, input().split()))
L.sort() 
M.sort()
K.sort()
i = 0 
while(i < len(M)) :
    if (M[i] != L[i]) :
        break
    i += 1
print(L[i])
i = 0 
while(i < len(K)) :
    if (M[i] != K[i]) :
        break
    i += 1
print(M[i])