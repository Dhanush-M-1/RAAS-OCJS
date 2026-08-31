from math import floor, ceil;
from sys import stdin, stdout;
#debug -->
#<-- debug
def main(status=int(0),max_size_of_string = 100,split_elm = '+'):
    math_line = input().split(split_elm);
    array_with_int_nums = sorted(list(map(int,math_line)),reverse=False);
    array_spliter = 0;
    for undetected in range(len(array_with_int_nums)+len(array_with_int_nums)-1):
        if (undetected%2 == 0):print(array_with_int_nums[array_spliter],end='');array_spliter+=1;
        else:print('+',end='');
main();
