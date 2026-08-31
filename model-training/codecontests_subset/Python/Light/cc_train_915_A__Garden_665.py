n, k = map(int, input().split())
ls = list(map(int, input().split()))
print(min([k//i for i in ls if k%i==0]))
