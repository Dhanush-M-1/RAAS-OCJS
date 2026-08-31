def solve():
    
    #Get input:
    n = int(input())
    first_comp = [int(x) for x in input().split()]
    second_comp = [int(x) for x in input().split()]
    third_comp = [int(x) for x in input().split()]
    
    #Calculate:
    print(sum(first_comp) - sum(second_comp))
    print(sum(second_comp) - sum(third_comp))
    return

solve()