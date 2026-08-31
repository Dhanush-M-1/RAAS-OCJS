# def seg_tree(arr,l,r,seg,ind):
#     if l==r:
#         seg[ind] = arr[l]

#     else:
#         mid = (l+r)//2

#         seg_tree(arr,l,mid,seg,2*ind+1)
#         seg_tree(arr,mid+1,r,seg,2*ind+2)

#         seg[ind] = seg[2*ind+1]+seg[2*ind+2]

# def get_sum(l1,r1,l2,r2,seg,ind):
    
#     if l1==l2 and r1==r2:
#         return seg[ind]
#     elif l1 > r1:
#         return 0
#     else:
#         mid = (l2+r2)//2
#         return get_sum(l1,min(r1,mid),l2,mid,seg,2*ind+1) + get_sum(max(l1,mid+1),r1,mid+1,r2,seg,2*ind+2)

# def modify(l,r,seg,arr,pos,val,ind):
#     if l==r:
#         seg[ind] = val
#         arr[pos] = val
#     else:
#         mid = (l+r)//2

#         if pos <= mid:
#             modify(l,mid,seg,arr,pos,val,2*ind+1)
#         else:
#             modify(mid+1,r,seg,arr,pos,val,2*ind+2)

#         seg[ind] = seg[2*ind+1]+seg[2*ind+2]


# n,q = map(int,input().split())

# arr = [0]*n

# seg = [None]*(4*len(arr))

# seg_tree(arr,0,len(arr)-1,seg,0)

# for i in range(q):
#     a,b,c = input().split()

#     if a=="a":
#         modify(0,len(arr)-1,seg,arr,int(b)-1,(arr[int(b)-1]+int(c))%2,0)
#     else:
#         print(int(c)+1-int(b) - get_sum(int(b)-1,int(c)-1,0,len(arr)-1,seg,0))

# def dijksta(graph,edge,n):

#     Unvisit = {(0,0)}
#     dist = [0]*n
#     for i in range(1,n):
#         Unvisit.add((10000000000,i))
#         dist[i] = 10000000000


#     while  Unvisit:

#         x = min(Unvisit)
#         Unvisit.remove(x)

#         u = x[1]
#         d = x[0]

#         for v in graph[u]:
#             if dist[u] + edge[u][v] < dist[v]:
#                 Unvisit.remove((dist[v],v))
#                 dist[v] =  dist[u] + edge[u][v]
#                 Unvisit.add((dist[v],v))
#     return dist[n-1]


# def power(x):
#     if x==0:
#         return 1
#     elif x==1:
#         return 2
#     else:
#         if x%2==0:
#             a = power(x//2)
#             a = a%1000000007
#             return (a*a)%1000000007
#         else:
#             a = power(x//2)
#             a = a%1000000007
#             return (2*a*a)%1000000007



n = int(input())

ans = 0
x = 1
for i in range(2,n+1):
    
    x = (x*i)%(10**9 +7)

y = 1
for i in range(n-1):
    y  = (2*y)%(10**9 +7) 

ans = (x-y)%(10**9 +7)
print(ans)


