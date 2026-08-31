import math

def distance(point1, point2 = (0, 0)):
    """Compute the euclidean distance between two points."""
    
    sqr_diff_x = (point1[0] - point2[0])**2
    sqr_diff_y = (point1[1] - point2[1])**2
    distance = math.sqrt(sqr_diff_x + sqr_diff_y)
    
    return distance

vertices, x, y = [int(i) for i in input().split(' ')]
start = (x, y)
vertex_indices = []

for i in range(int(vertices)):
    point = input().split(' ')
    vertex_indices.append((int(point[0]), int(point[1])))
vertex_indices =  vertex_indices

boundary_test = 1/math.sqrt(2)
largest_distance = float('Inf')
prev_distance = None
cur_distance = 0
min_distance = largest_distance
max_distance = -largest_distance

for i in range(len(vertex_indices)):
    
    prev = vertex_indices[i - 1]
    cur = vertex_indices[i]

    cur_to_start = (start[0] - cur[0], start[1] - cur[1])
    cur_to_prev = (prev[0] - cur[0], prev[1] - cur[1])
    dot_product1 = cur_to_start[0]*cur_to_prev[0] + cur_to_start[1]*cur_to_prev[1]
    
    prev_to_start =  (start[0] - prev[0], start[1] - prev[1])
    prev_to_cur = (-cur_to_prev[0], -cur_to_prev[1])
    dot_product2 = prev_to_start[0]*prev_to_cur[0] + prev_to_start[1]*prev_to_cur[1]
    
    on_inside = dot_product1 > 0 and dot_product2 > 0
    on_boundary = dot_product1 == 0
    

    min_distance_test = max_distance_test = distance(cur_to_start)
    
    if on_inside:
        
        numerator = math.fabs(prev_to_cur[1]*start[0] - prev_to_cur[0]*start[1] 
                    + cur[0]*prev[1] - cur[1]*prev[0])
                    
        denominator = distance(prev_to_cur)

        min_distance_test = numerator/denominator
    
    if min_distance_test < min_distance:
        min_distance = min_distance_test
        
    if max_distance_test > max_distance:
        max_distance = max_distance_test
    
area = math.pi*(max_distance**2 - min_distance**2)

print(area)