n = int(input())
p_cost, t_cost = map(int, input().split())
p_cal = int(input())
t_cal = []
for i in range(n) :
    t_cal.append(int(input()))

t_cal.sort(reverse = True)

total_cost = p_cost
total_cal = p_cal
max_total_cal_par_doll = total_cal // total_cost
for i in range(n) :
    total_cost += t_cost
    total_cal += t_cal[i]
    total_cal_par_doll = total_cal // total_cost
    if max_total_cal_par_doll < total_cal // total_cost :
        max_total_cal_par_doll = total_cal // total_cost
        
print(max_total_cal_par_doll)
    
