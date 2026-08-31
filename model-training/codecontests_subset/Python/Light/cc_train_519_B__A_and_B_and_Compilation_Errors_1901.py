a = int(input())
b = list(map(int,input().split()))
c = list(map(int,input().split()))
d = list(map(int,input().split()))
b_sum = sum(b)
c_sum = sum(c)
m1 = b_sum - c_sum
d_sum = sum(d)
m2 = c_sum-d_sum
print(m1)
print(m2)
