from collections import Counter as C
n = int(input())
a = C(input().split())
b = C(input().split())
c = C(input().split())
print(list((a-b).elements())[0])
print(list((b-c).elements())[0])
