import sys
input = sys.stdin.readline
 
'''
 
'''
 
def solve(n, k, t, a, b):
    alice_only = []
    bob_only = []
    both = []
    
    for i in range(n):
        if a[i] and b[i]:
            both.append(t[i])
        elif a[i] and not b[i]:
            alice_only.append(t[i])
        elif b[i] and not a[i]:
            bob_only.append(t[i])
 
    if len(bob_only) + len(both) < k:
        return -1
    elif len(alice_only) + len(both) < k:
        return -1
 
    bob_only.sort()
    alice_only.sort()
    both.sort()
 
    both_pre = [0]
    bob_pre = [0]
    alice_pre = [0]
 
    for tb in bob_only:
        bob_pre.append(bob_pre[-1] + tb)
    
    for ta in alice_only:
        alice_pre.append(alice_pre[-1] + ta)
    
    for tbth in both:
        both_pre.append(both_pre[-1] + tbth)
    
    best = float("inf")
 
    #print(both_pre)
    #print(alice_pre)
    #print(bob_pre)
 
    lb1 = k - len(alice_only)
    lb2 = k - len(bob_only) 
 
    for cur_k in range(max(lb1, lb2, 0), min(len(both_pre), k+1)):
        
        time_both = both_pre[cur_k]
        time_alice = alice_pre[k-cur_k]
        time_bob = bob_pre[k-cur_k]
        best = min(best, time_both+time_alice+time_bob)
        #print(best, cur_k)
    
    if len(alice_pre) > k and len(bob_pre) > k:
        best = min(best, alice_pre[k] + bob_pre[k])
 
    return best
 
n, k = map(int, input().split())
t, a, b = [], [], []
for _ in range(n):
    ti, ai, bi = map(int, input().split())
    t.append(ti)
    a.append(ai)
    b.append(bi)
 
print(solve(n, k, t, a, b))