import math
def question1():
    total_people,wizzards,percent_required = map(int,input().split())
    required_people = math.ceil((total_people * percent_required) / 100)
    # print(required_people)
    if required_people <= wizzards:
        return 0 
    return required_people - wizzards    
    
remained_test_cases = 1 
# remained_test_cases = int(input())
while remained_test_cases > 0:
    print(question1())
    remained_test_cases -= 1 