#379/A

a, b = list(map(int,input().split()))

start, stop = 0, a
while start<stop:
  start +=b
  if start<=stop:
    stop+=1
    
print(stop)