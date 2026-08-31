# import statistics
# import math
# import datetime
# import collections

def identity(*args):
    """ Always returns the same value that was used as its argument.

    Example:
    >>> identity(1)
    1
    >>> identity(1, 2)
    (1, 2)
    """
    if len(args) == 1:
        return args[0]
    return args


def parsin(*, l=1, vpl=1, cf=identity, s=" "):
    """ Can parse inputs usually used in competitive programming problems.
    Arguments:
    - l, as in "Lines", the number of lines to parse at once.
    - vpl, as in "Values Per Line", the number of values to parse per line.
    - cf, as in "Cast Function", the function to apply to each parsed element.
    - s, as in "Separator", the string separating multiple values in the same
      line.
    """
    if l == 1:
        if vpl == 1:
            return cf(input())
        else:
            return list(map(cf, input().split(s)))
    else:
        if vpl == 1:
            return [cf(input()) for _ in range(l)]
        else:
            return [list(map(cf, input().split(s)))
                    for _ in range(l)]

def condition_satisfy(a:int):
    steps = 0
    while a!=1:
        if a%6==0:
            a/=6
        elif a%3!=0:
            return -1
        else: 
            a*=2
        steps+=1
    return steps

def main():
    t= int(input())
    if t == 1:
        print(condition_satisfy(int(input())))
        return 0
    for each in parsin(l=t,vpl=1,cf=int,s="\n"):
        print(condition_satisfy(each))


if __name__ == '__main__':
    main()