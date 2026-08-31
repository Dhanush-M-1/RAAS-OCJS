n,m=list(map(int,input().split(' ')))
set_of_all_bulbs=set(range(1,m+1))
for i in range(n):
    connection_list=list(map(int,input().split()))
    no_of_connections=connection_list.pop(0)
    set_of_all_bulbs=set_of_all_bulbs.difference(set(connection_list))
    #print(set_of_all_bulbs)
    if(len(set_of_all_bulbs)==0):
        print('YES')
        exit(0)
print('NO')
