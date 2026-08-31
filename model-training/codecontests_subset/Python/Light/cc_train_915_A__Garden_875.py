import math
from sys import stdin
string1=stdin.readline().strip().split()
string2=stdin.readline().strip().split()
bucketnumber=int(string1[0])
garden=int(string1[1])
output=garden

for item in string2:
    bucket=int(item)
    if garden%bucket==0:
        if garden/bucket<output:
            output=garden/bucket

print(int(output))