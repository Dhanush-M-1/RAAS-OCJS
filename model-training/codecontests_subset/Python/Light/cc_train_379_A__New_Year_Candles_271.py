
#n = int(input())
n, m = map(int, input().split())
#s = input()
#c = list(map(int, input().split()))
'''for i in range(n):
    c = list(map(int, input().split()))'''
l = 0
while n >= m:
    l += (n // m) * m
    n = n // m + n % m
l += n
print(l)
