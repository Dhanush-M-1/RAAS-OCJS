import collections
import operator


if __name__ == "__main__":
    for _ in range(int(input())):
        n = int(input())
        ll = [int(i) for i in input().split(" ")]
        size = len(ll)
        noyes = True
        d = collections.defaultdict(int)
        for i in range(size):
            # print((ll[i] + i + 1)% size, size)
            if d[(ll[i] + i + 1)% size] > 0:
                print("NO")
                noyes = False
                break
            d[(ll[i] + i + 1)%size] += 1
        if noyes: print("YES")


                
   