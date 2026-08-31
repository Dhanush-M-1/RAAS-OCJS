from collections import Counter
def ans(arr):
    tmp = arr.count('8')
    return(min(t // 11, tmp))
if __name__ == '__main__':
    t = int(input())
    n = input()
    print(ans(n))
        