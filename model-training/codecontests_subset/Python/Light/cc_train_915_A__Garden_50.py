import sys

ipt = input().split()
n = int(ipt.pop(0))
k = int(ipt.pop(0))

numbers = [int(i) for i in input().split()]

times = []

for n in numbers:
    if k % n == 0:
        times.append(n)

result = int(k / max(times))
print(result)

  	   		       	 			  	 	 			