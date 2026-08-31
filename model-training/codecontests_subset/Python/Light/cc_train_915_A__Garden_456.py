n,c = input().split()
n = int(n)
c = int(c)
x = [int(x) for x in input().split()] 
maximum = 0
for num in x:
    if c%num==0 and num>maximum:
        maximum=num
print(int(c/maximum))