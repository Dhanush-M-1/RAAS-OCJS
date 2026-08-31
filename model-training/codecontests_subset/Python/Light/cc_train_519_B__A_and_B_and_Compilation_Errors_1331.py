__author__ = 'dougct'

"""
Let's denote a as sum of all elements of first array, 
b as sum of all elements of second array and c as sum
of all elements of third array. 
Then the answer is a - b and b - c.
"""

def main():
    n = int(input())
    # First compilation.
    a = sum(list(map(int, input().split())))
    # Second compilation.
    b = sum(list(map(int, input().split())))
    # Third compilation.
    c = sum(list(map(int, input().split())))
    print(a - b)
    print(b - c)


if __name__ == '__main__':
    main()