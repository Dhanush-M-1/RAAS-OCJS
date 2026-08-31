def find_factor(n):
    divisor = []
    for i in range(1,int(n**(1/2))+1):
        if n%i == 0:
            divisor.append(i)
            divisor.append(n//i)
    return set(divisor)

n,k = list(map(int,input().split()))
a = list(map(int,input().split()))
a = [i for i in a if i in find_factor(k)]
print(k//max(a))