def get_minimum(l,r,d, x):
    minimum = x*d
    if not(minimum < l or minimum > r):
        minimum = get_minimum(l,r,d,int(r/d)+1)
    return minimum

def min_integer(queries):
    results = []
    for query in queries:
        l,r,d = query
        results.append(get_minimum(l,r,d, 1)) 
    return results

def get_queries(q):
    queries = []
    while q > 0:
        l,r,d = input().split(' ')
        l,r,d = int(l), int(r), int(d)        
        queries.append([l,r,d])
        q -= 1
    return queries

queries = get_queries(int(input()))
results = min_integer(queries)

for r in results:
    print(r)
		 				   		   	  			     					