
n, k = map(int,input().split())
w = list(map(int,input().split()))
w = [i for i in w if k%i == 0]
print(k//max(w))
    
    
    










