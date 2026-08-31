n , k = input().split()
n = int(n)
k = int(k)
def cal(a,b):
    s = 0 
    while a - b >= 0:
        a = a-b
        a += 1
        s+=1
    return s
print(cal(n,k)+n)