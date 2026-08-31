class DisjointSet():
    def __init__(self, N):
        super().__init__()
        self.N = N
        self.parent = [i for i in range(self.N)]
        self.rank = [0 for i in range(self.N)]

    def find(self, x):
        temp = x
        while self.parent[temp]!=temp:
            temp = self.parent[temp]
        self.parent[x] = temp
        return self.parent[x]

    def union(self, x, y):
        repx = self.find(x)
        repy = self.find(y)
        if repx==repy: return
        elif self.rank[repx]<self.rank[repy]: self.parent[repx] = repy
        elif self.rank[repx]>self.rank[repy]: self.parent[repy] = repx
        else:
            self.parent[repx] = repy
            self.rank[repy] += 1
        return

def mergeSort(l, r, arr, reverse=False, cmp=lambda x, y: x<=y):
    if r-l==1: return arr[l:r]
    mid = (r+l)//2
    arr1 = mergeSort(l, mid, arr)
    arr2 = mergeSort(mid, r, arr)
    i, j = 0, 0
    while i<mid-l and j<r-mid:
        if ((not reverse) and cmp(arr1[i], arr2[j])) or (reverse and (not cmp(arr1[i], arr2[j]))):
            arr[i+j] = arr1[i]
            i += 1
        else:
            arr[i+j] = arr2[j]
            j += 1
    while i<mid-l:
        arr[i+j] = arr1[i]
        i += 1
    while j<r-mid:
        arr[i+j] = arr2[j]
        j += 1
    return arr[:]

T = int(input())
for test_case in range(T):
    # N = int(input())
    # L = list(map(int, input().split()))
    # T = list(map(int, input().split()))
    a, b, n = map(int, input().split())
    if n%3==0: print(a)
    elif n%3==1: print(b)
    else: print(a^b)
