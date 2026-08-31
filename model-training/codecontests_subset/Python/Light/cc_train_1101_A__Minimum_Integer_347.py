#   Codeforces
#   #110A   -   Minimum Integer
#   http://codeforces.com/problemset/problem/1101/A
#   11/01/2019
#   Nilton G. M. Junior

if __name__ == '__main__':
    num_queries = int(input())
    for i in range(num_queries):
        l, r, d = list(map(int, input().split()))
        print(d if d < l else d * (1 + r // d))
