
n  =  int(input())
a = list(map(int, input().split()))
b  =  list(map(int, input().split()))
c = list(map(int, input().split()))

a_sum = sum(a)
b_sum = sum(b)
c_sum = sum(c)

print(a_sum - b_sum)
print(b_sum - c_sum)