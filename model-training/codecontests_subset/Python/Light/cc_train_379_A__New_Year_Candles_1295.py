a, b=map(int, input().split())
hours=a
cur_a=a
cur_b=0
while cur_a>0:
    cur_b+=cur_a
    cur_a=cur_b//b
    cur_b%=b
    hours+=cur_a
print(hours)