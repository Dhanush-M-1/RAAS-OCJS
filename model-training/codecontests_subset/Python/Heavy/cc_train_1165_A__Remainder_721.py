from sys import stdin
##  input functions for me
def ria(sep = ''):
    if sep == '' :
        return list(map(int, input().split())) 
    else: return list(map(int, input().split(sep)))
def rsa(sep = ''):
    if sep == '' :
        return input().split() 
    else: return input().split(sep)
def ri(): return int(input())
def rd(): return float(input())
def rs(): return input()
##

## main ##
N, X, Y = map(int, input().split())
S = rs()
cnt = 0
for i in range(Y):
    if S[N - 1 - i] == '1': cnt += 1
if S[N - 1 - Y] == '0' : cnt += 1
for i in range(Y + 1, X):
    if S[N - 1 - i] == '1': cnt += 1

print(cnt)




