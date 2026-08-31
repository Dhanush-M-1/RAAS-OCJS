n,k = [int(x) for x in input().split()]
a = [int(x) for x in input().split()]
hours = []
for i in a:
    if (k%i==0):
        hours.append(k/i)
print(int(min(hours)))