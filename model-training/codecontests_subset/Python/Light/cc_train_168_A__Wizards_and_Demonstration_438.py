n,x,y=map(int,input().split())
print(max(0, -((100 * x - n * y) // 100)))