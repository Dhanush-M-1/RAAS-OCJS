def fun():
    n = int(input())
    a = list(map(int, input().split()))
    if a[n-1] < (a[0] + a[1]):
        print('-1')
    else:
        print('1 2 '+ str(n))


for i in range(int(input())):
    fun()