# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
from sys import stdin, stdout
import math

#T = int(input())
N = int(input())
s = input()
#N,K = [int(x) for x in stdin.readline().split()]
#arr = [int(x) for x in stdin.readline().split()]

freq = {}

for i in range(N-1):
    two_gram = s[i] + s[i+1]
    if two_gram not in freq:
        freq[two_gram] = 1
    else:
        freq[two_gram] += 1
        
maximum = max(freq, key=freq.get)
print(maximum)