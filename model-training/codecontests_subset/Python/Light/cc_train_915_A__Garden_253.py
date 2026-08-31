n, k = list(map(int, input().split()))
print(k//max([i for i in list(map(int, input().split())) if k%i==0]))

        