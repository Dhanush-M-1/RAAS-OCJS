# RawCoder : https://bit.ly/RCyouTube
# Author : MehulYK

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))  
su1 = sum(a)
su2 = sum(b)
su3 = sum(c)
print(abs(su1 - su2))
print(abs(su2 - su3))