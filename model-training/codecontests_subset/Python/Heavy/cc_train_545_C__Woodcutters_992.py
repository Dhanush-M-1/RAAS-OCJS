fibonacci_cache={}
def fibonacci(n):
    if n in fibonacci_cache:
        return fibonacci_cache[n]
    elif (n==1) | (n==2):
        return 1
    else:
        fibonacci_cache[n] = (fibonacci(n - 1) + fibonacci(n - 2))
        return fibonacci_cache[n]





def check_tree(it):
    if (((tree_x1[it]-tree_height[it]) not in tree_x1)
            & ((tree_x1[it]-tree_height[it]) not in tree_x2)
            & ((tree_x1[it]+tree_height[it]) not in tree_x1)
            & ((tree_x1[it]+tree_height[it])not in tree_x2)):
        return 0
    elif(((tree_x1[it]+tree_height[it]) in tree_x1) | ((tree_x1[it]+tree_height[it]) in tree_x2) )\
            &(((tree_x1[it]-tree_height[it]) not in tree_x1) & ((tree_x1[it]-tree_height[it])not in tree_x2)):
        return 0
    elif(((tree_x1[it]-tree_height[it]) in tree_x1) | ((tree_x1[it]-tree_height[it]) in tree_x2))\
        &(((tree_x1[it]+tree_height[it]) not in tree_x1) & ((tree_x1[it]+tree_height[it]) not in tree_x2) ):
        return 0
    else:
        return -1

def max_cuts(n_trees):
    if n_trees ==0:
        return 0
    elif (check_tree[n_trees]!=-9):

     q=-9999999
    for i in range(1,n_trees+1):
        q = max(q,max_cuts(n_trees-1)+1)

    return q





def greedy_woodcut():
    counter=1
    if(int(n)>=2):
       counter=2

    for i in range(1,int(n)-1):
        if((tree_x1[i]-tree_x1[i-1])>tree_height[i]):
            counter+=1
        elif ((tree_x1[i+1]- tree_x1[i])>tree_height[i] ):
            tree_x1[i]+=tree_height[i]
            counter+=1
    return counter




n= input()
tree_x1=list()
tree_height=list()
for i in range(0,int(n)):
    line=input()
    x,h=line.split()
    tree_x1.append(int(x))
    tree_height.append(int(h))
print(greedy_woodcut())