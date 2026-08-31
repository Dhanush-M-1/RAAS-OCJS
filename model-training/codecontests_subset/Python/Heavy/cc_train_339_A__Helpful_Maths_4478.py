expression = input()

values = {}

values['1'] = 0
values['2'] = 0
values['3'] = 0

for i in range(len(expression)):
    if expression[i] != '+':
        values[expression[i]] += 1
        
newExpression = ''
for count in range(values['1']):
    newExpression += '1'
    newExpression += '+'
    
for count in range(values['2']):
    newExpression += '2'
    newExpression += '+'

for count in range(values['3']):
    newExpression += '3'
    newExpression += '+'
    
print(newExpression[:-1])

            



