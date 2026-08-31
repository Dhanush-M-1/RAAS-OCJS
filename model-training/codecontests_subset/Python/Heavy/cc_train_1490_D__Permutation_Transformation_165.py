#!/usr/bin/python

import sys

def argmax(A):
    idx = -1
    my_max = -1
    for i in range(len(A)):
        if A[i] > my_max:
            my_max = A[i]
            idx = i
    return idx
    
def solve(N, A):
    used_idxes = []
    ered = ['x'] * len(A)
    idx = argmax(A)
    #print(idx)
    used_idxes.append(idx)
    ered[idx] = 0
    max_value = 0
    while len(used_idxes) < N:
        #print(max_value, used_idxes)
        used_idxes_copy = [i for i in used_idxes]
        if used_idxes_copy[0] > 0:
            arr1 = A[:used_idxes_copy[0]]
            #print('arr1', arr1)
            if len(arr1) > 0:
                idx = argmax(arr1)
                ered[idx] = max_value + 1
                used_idxes.append(idx)
        if used_idxes[-1] < N - 1:    
            arr2 = A[used_idxes_copy[-1]+1:]
            #print('arr2', arr2)
            if len(arr2) > 0:
                idx = argmax(arr2)
                ered[used_idxes_copy[-1] + idx + 1] = max_value + 1
                used_idxes.append(used_idxes_copy[-1] + idx + 1)
                #print(used_idxes_copy[-1] + idx + 1)
            
        for i in range(len(used_idxes_copy)-1):
            arr3 = A[used_idxes_copy[i]+1:used_idxes_copy[i+1]]
            #print('arr3',arr3, used_idxes_copy[i], used_idxes_copy[i+1])
            if len(arr3) > 0:
                idx = argmax(arr3)
                ered[used_idxes_copy[i] + idx + 1] = max_value + 1
                used_idxes.append(used_idxes_copy[i] + idx + 1)
        #print(ered)
        max_value += 1
        used_idxes = sorted(used_idxes)
    return " ".join([str(e) for e in ered])
    
def run():
    out = ""    
    T = int(input())
    for i in range(T):
        N = int(input())
        A = [int(x) for x in input().split()]
        print(solve(N, A))

run()

