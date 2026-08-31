# Enter your code here. Read input from STDIN. Print output to STDOUT
def find(books,k):
    both = []
    A = []
    B = []
    # both + (k-both) + (k-both)
    for (t,a,b) in books:
        if a == 1 and b == 1:
            both += [t]
        elif a == 1:
            A += [t]
        elif b == 1:
            B += [t]
    
    both = sorted(both)
    A = sorted(A)
    B = sorted(B)
    
    ans = 10**10
    num = 0
    
    temp = 0
    pre_both = []
    for i in range(len(both)):
        temp += both[i]
        pre_both += [temp]
    
    temp = 0
    pre_A = []
    for i in range(len(A)):
        temp += A[i]
        pre_A += [temp]
        
    temp = 0
    pre_B = []
    for i in range(len(B)):
        temp += B[i]
        pre_B += [temp]
        
    for num in range(min(k,len(pre_both))+1):
        if num>len(pre_both):
            break
        if num>0:
            need = pre_both[num-1]
            if num == k:
                ans = min(ans,need)
                break
        remain = k-num
        if remain>len(A):
            continue
        if remain>len(B):
            continue
        if num>0:
            need = pre_both[num-1] + pre_A[remain-1] + pre_B[remain-1]
        else:
            need = pre_A[remain-1] + pre_B[remain-1]
        ans = min(ans,need)
    if ans == 10**10:
        return -1
    return ans


n,k = list(map(int,input().strip().split()))
books = []
for _ in range(n):
    t,a,b = list(map(int,input().strip().split()))
    books +=[(t,a,b)]
print(find(books,k))
    