def isEquivalent(a_total, b_total):
    if(a_total == b_total):
        return True
    if(len(a_total) != len(b_total)):
      return False
    if(len(a_total) % 2 == 1):
        return False
    half = len(a_total)//2
 
    a_part1 = a_total[:half]
   
    b_part1 = b_total[:half]
    a_part2 = a_total[half:]
    b_part2 = b_total[half:]
 
    return (isEquivalent(a_part1, b_part2) and isEquivalent(a_part2, b_part1)) or (isEquivalent(a_part1, b_part1) and isEquivalent(a_part2, b_part2))
 
 
a_total = input()
b_total = input()
 
if (isEquivalent(a_total, b_total)):
    print('YES') 
else:
    print('NO')
