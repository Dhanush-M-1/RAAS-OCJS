A=list(map(int,input().split()))
print(("No","Yes")[max(A)==sum(A)-max(A)])
