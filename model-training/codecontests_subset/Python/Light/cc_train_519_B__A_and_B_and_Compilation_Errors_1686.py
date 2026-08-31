n=int(input())
errors=list(map(int,input().split()))
error1=list(map(int,input().split()))
error2=list(map(int,input().split()))
print(sum(errors)-sum(error1),sum(error1)-sum(error2))
        
