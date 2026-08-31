n = int(input())
alpha = "abcdefghij"
lst = []
def f(s,k):
    if len(s) == n:
        print(s) 
        return
    for i in range(k+1):
        if i == k: f(s+alpha[i],k+1)
        else: f(s+alpha[i],k)
f("",0)