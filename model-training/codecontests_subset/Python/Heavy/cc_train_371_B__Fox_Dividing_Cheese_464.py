import math
import sys

def main():
    a, b = map(int, input().split())
    two_a, two_b, three_a, three_b, five_a, five_b = 0, 0, 0, 0, 0, 0
    while a%2 == 0:
        two_a += 1
        a /= 2
    while a%3 == 0:
        three_a += 1
        a /= 3
    while a%5 == 0:
        five_a += 1
        a /= 5
    while b%2 == 0:
        two_b += 1
        b /= 2
    while b%3 == 0:
        three_b += 1
        b /= 3
    while b%5 == 0:
        five_b += 1
        b /= 5
    if a != b:
        print(-1)
    else:
        print(abs(two_a - two_b) + abs(three_a - three_b) + abs(five_a - five_b))


if __name__ == '__main__':
    main()
	    				 			 	  	 	 	 	 	 		