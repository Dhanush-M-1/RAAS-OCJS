a,b = input().split()
a = int(a)
b = int(b)
hour = 0
count = a
n = 0
while count != 0:
    count = count - 1
    hour = hour + 1
    n = n + 1
    while n == b:
        count = count + 1
        n = 0
print(hour)
    