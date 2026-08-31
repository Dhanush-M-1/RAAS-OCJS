def one_indexed(pair):
    return [item + 1 for item in pair]

t = int(input())

for i in range(t):
    n = int(input())
    grid = [[int(i) if (i != "S" and i != "F") else i for i in list(input())] for j in range(n)]
    
    doors = [(0, 1), (1, 0), (n - 2, n - 1), (n - 1, n - 2)]
    door_vals = [grid[i][j] for i, j in doors]
    sr, sd, fu, fl = door_vals
    
    if sr == sd and fu == fl and sr != fu:
        print(0)
        
    else:
        if door_vals.count(0) == 1:
            diff_ind = door_vals.index(0)
        elif door_vals.count(1) == 1:
            diff_ind = door_vals.index(1)
        else:
            diff_ind = None
            
        if not(diff_ind is None):
            print(1)
            
            get_other = {
                0: 1,
                1: 0,
                2: 3,
                3: 2,
            }
            change_ind = get_other[diff_ind]
            change = doors[change_ind]
            print(*one_indexed(change))
            
        else:
            print(2)
            
            if len(set(door_vals)) == 1:
                for coords in [doors[0], doors[1]]:
                    print(*one_indexed(coords))
            elif (sr in (fu, fl)) and (sd in (fu, fl)) and fu != fl:
                changes = [doors[i] for i in range(4) if (i <= 1 and door_vals[i] == 0) or (i >= 2 and door_vals[i] == 1)]
                for coords in changes:
                    print(*one_indexed(coords))