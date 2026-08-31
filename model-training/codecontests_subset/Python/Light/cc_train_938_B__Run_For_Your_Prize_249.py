num = input()
pos = [int(i) for i in input().split(' ')]
sub = (pow(10,6)+1)/2
minimum = 10000000
for i in pos:
    minimum = min(minimum,abs(i-sub))
print(int(sub-minimum-1))
