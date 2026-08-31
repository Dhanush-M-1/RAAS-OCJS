import sys
import math

#to read string
get_string = lambda: sys.stdin.readline().strip()
#to read list of integers
get_int_list = lambda: list( map(int,sys.stdin.readline().strip().split()) )
#to read integers
get_int = lambda: int(sys.stdin.readline())
#to print fast
#pt = lambda x: sys.stdout.write(str(x)+'\n')

#--------------------------------WhiteHat010--------------------------------------#
n = get_int()
initial = get_int_list()
first = get_int_list()
sec = get_int_list()
res = []
s1 = sum(initial)
s2 = sum(first)
s3 = sum(sec)
res.append(s1-s2)
res.append(s2-s3)
print(*res)

