def solve():
    n = int(input())
    points = [(int(number) for number in input().split()) for _ in range(n)]
    p_prev, c_prev = points[0]
    if c_prev > p_prev:
        return "NO"
    for p_curr, c_curr in points[1:]:
        if c_curr > p_curr:
            return "NO"
        if p_curr == p_prev:
            if c_curr != c_prev:
                return "NO"
        elif p_curr > p_prev:
            if c_prev < c_prev:
                return "NO"
        else:
            return "NO"
        delta_p = p_curr - p_prev
        delta_c = c_curr - c_prev
        if delta_p < 0:
            return "NO"
        if delta_c < 0:
            return "NO"
        if delta_p < delta_c:
            return "NO"
        p_prev, c_prev = p_curr, c_curr
    return "YES"


task_number = int(input())
for _ in range(task_number):
    print(solve())
