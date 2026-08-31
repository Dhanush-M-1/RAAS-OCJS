def triangle(a,b,c):
    if a+b>c and b+c>a and a+c>b:
        return True
    else:
        return False


for _ in range(int(input())):
    a = int(input())
    b = list(int(x) for x in input().split())
    if triangle(b[0],b[1],b[-1])==False:
        print(1,2,a)
    else:
        print(-1)