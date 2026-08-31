## implementation 1 using all possible combinations
def primes(n):
    dick = {}
    while(n%2 == 0):
        dick[2] = dick.get(2, 0) + 1
        n = n // 2
    for i in range(3, int(n**0.5)+1, 2):
        while(n%i == 0):
            dick[i] = dick.get(i, 0) + 1
            n = n // i
    if n > 2:
        dick[n] = dick.get(n, 0) + 1
    return dick

def combs(this, index, curr):
    global ans
    
    if index == len(this):
        ans.append(curr)
        return
    combs(this, index+1, curr*this[index])
    combs(this, index+1, curr)

n = int(input())
dick = primes(n)
array = []
for i in dick:
    array.append(i**dick[i])

index = 0; curr = 1; ans = []
combs(array, index, curr)
answer = 1e13
for i in ans:
    answer = min(answer, max(i, n//i))
print(min(answer, n//answer), max(answer, n//answer))