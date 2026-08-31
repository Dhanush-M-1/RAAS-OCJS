def compute(n, k, arr):
    add = 0
    both = []
    alice = []
    bob = []
    for i in range(n):
        if arr[i][1] and arr[i][2]:
            both.append(arr[i][0])
            
        elif arr[i][1]:
            alice.append(arr[i][0])

        elif arr[i][2]:
            bob.append(arr[i][0])

    both.sort()
    alice.sort()
    bob.sort()

    #print(alice, bob, both)

    if (len(alice)+len(both) < k) or (len(both)+len(bob) < k):
        return -1

    else:
        i, j = 0, 0
        n, nn, nnn = len(alice), len(bob), len(both)
        for _ in range(k):

            if not alice or not bob or j >= n or j > nn or (i < nnn and both[i] <= alice[j] + bob[j]):
                add += both[i]
                i += 1
            else:
                add += (alice[j] + bob[j])
                j += 1
                
        return add





if __name__ == "__main__":
    n, k = map(int, input().split())
    arr = []
    for _ in range(n):
        t, a, b = map(int, input().split())
        arr.append([t, a, b])
    print(compute(n, k, arr))
