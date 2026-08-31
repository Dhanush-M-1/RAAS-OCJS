'''
from tkinter import *
from tkinter import messagebox as mb
from tkinter import filedialog
w=Tk()
w.title('window')

w.geometry('500x200')
rv=BooleanVar()
rv1=IntVar()
cv=DoubleVar()
cv1=DoubleVar()
cv2=DoubleVar()
cv3=DoubleVar()
color='white'
sum=0
def color1():
    if rv1.get() == 0:
        color='blue'
        l.config(bg=color)
    elif rv1.get() == 1:
        color='red'
        l.config(bg=color)
    elif rv1.get()==2:
        color='green'
        l.config(bg=color)
def tasks():
    sum=cv.get()+cv1.get()+cv2.get()+cv3.get()
    l1.config(text=sum)       
r=Radiobutton(text= 'radiobutton 1',variable = rv,value = 1)
r.place(x=10,y=3)
r1=Radiobutton(text='radiobutton 2',variable = rv,value = 0)
r1.place(x=100,y=3)
rb=Radiobutton(text='blue',variable = rv1,value = 0,command=color1)
rb.place(x=3,y=40)
rb1=Radiobutton(text='red',variable = rv1,value = 1,command=color1)
rb1.place(x=3,y=60)
rb2=Radiobutton(text='green',variable = rv1,value = 2,command=color1)
rb2.place(x=3,y=80)
l=Label(width='30',height='10',bg='white')
l.place(x=3,y=100)
c1=Checkbutton(text='1 task',variable=cv,onvalue = 2.5,offvalue = 0,command = tasks)
c1.place(x=300,y=20)
c2=Checkbutton(text='2 task',variable=cv1,onvalue = 5,offvalue = 0,command = tasks)
c2.place(x=300,y=40)
c3=Checkbutton(text='3 task',variable=cv2,onvalue = 7.5,offvalue = 0,command = tasks)
c3.place(x=300,y=60)
c4=Checkbutton(text='4 task',variable=cv3,onvalue = 10,offvalue = 0,command = tasks)
c4.place(x=300,y=80)
l1=Label()
l1.place(x=300,y=100)

def Loadfile():
    filename = filedialog.Open(w, filetypes = [('*.txt files', '.txt')]).show()
    if filename =='':
        return
    t.delite('1.0', 'end')
    t.insert('1.0', open(filename, 'rt').read())
def Savefile():
    filename = filedialog.SaveAs(w, filetypes = [('*.txt files', '.txt')]).show()
    if filename =='':
        return
    if not filename.endswith(".txt"):
        filename+=".txt"
    open(filename, 'wt').write(textbox.get('1.0', 'end'))
def quit():
    global w
    answer=mb.askyesno("quit?","Quit?")
    if answer==True:
        w.destroy()
panel = Frame(w,height = 60,bg='gray')
panel.pack(side='top', fill = 'x')
textframe = Frame(width=340, height = 600)
textframe.pack(side ='bottom',fill= 'both')
t=Text(textframe,wrap = 'word')
t.pack(side = 'left',fill='both')
scroll = Scrollbar(textframe)
scroll.pack(side = 'right',fill = 'y')
scroll['command'] = t.yview
t['yscrollcommand'] = scroll.set
load=Button(panel,bg='purple',text='load',command = Loadfile)
load.place(x=10,y=10,width=40,height=40)
save=Button(panel,bg='purple',text='save',command = Savefile)
save.place(x=50,y=10,width=40,height=40)
quit=Button(panel,bg='purple',text='quit', command = quit)
quit.place(x=600,y=10,width=40,height=40)
w.mainloop()

def red():
    lb.config(text=code[0])
    lb2.config(text=color[0])
def ora():
    lb.config(text=code[1])
    lb2.config(text=color[1])
def ye():
    lb.config(text=code[2])
    lb2.config(text=color[2])
def gr():
    lb.config(text=code[3])
    lb2.config(text=color[3])
def blu():
    lb.config(text=code[4])
    lb2.config(text=color[4])
def blue2():
    lb.config(text=code[5])
    lb2.config(text=color[5])
def vio():
    lb.config(text=code[6])
    lb2.config(text=color[6])
w.geometry('205x380')
w.resizable(False,False)
lb=Label(text='',font ='Arial,14', bg='#ffffff', width=20, height=2)
lb.pack()
lb2=Label(text='',font ='Arial,14', bg='#ffffff', width=20, height=2)
lb2.pack()
code=['#FF0000','#FFA500', '#FFFF00' ,'#008000', '#0000FF', '#000080', '#4B0082']
color=['красный', 'оранжевый', 'желтый', 'зелёный', 'голубой', 'синий', 'фиолетовый']
br=Button(bg=code[0], width=25, height=2, command=red)
br.pack()
bo=Button(bg=code[1], width=25, height=2, command=ora)
bo.pack()
by=Button(bg=code[2], width=25, height=2, command=ye)
by.pack()
bb1=Button(bg=code[3], width=25, height=2, command=gr)
bb1.pack()
b1=Button(bg=code[4], width=25, height=2, command=blu)
b1.pack()
bv=Button(bg=code[5], width=25, height=2, command=blue2)
bv.pack()
b12=Button(bg=code[6], width=25, height=2, command=vio)
b12.pack()


import random
import time


size = 500
c=Canvas(w, width=size, height=size)
c.pack()
while True:
    col=choice(['pink', 'orange', 'purple', 'yellow', 'lime'])
    x0=randint(0, size)
    y0= randint(0, size)
    d= randint(0, size/5)
    c.create_oval(x0,y0,x0+d,y0+d,fill=col)
    w.update()

def Intro():
    print(Вы находитесь в земле, полной драконов.
Перед собой, ты видишь две пещеры.
В одной пещере дракон дружелюбен и поделится с тобой своим сокровищем.
Другой дракон жадный и голодный, и хочет тебя съесть.)
def choose():
    while True:
        a=int(input())
        if a!= 1 and a!=2:
            continue
        else:
            return a
def check_cave(choose):
    print(Вы приближаетесь к пещере...)
    time.sleep(2)
    print('Она тёмная и жуткая...)
    time.sleep(2)
    print('Большой дракон выпрыгивает прямо перед вами!')
    print('Он открывает свои челюсти и…')
    print('')
    time.sleep(2)
    b=random.randint(1,2)
    if b==choose:
        print('Это добрый!')
    else:
        print("Это злой!!!")
check=1
while check==1:
    Intro()
    check_cave(choose())
    check=int(input('1-yes,0-no'))
   
name=input()
print("Привет, я",(name),".\nЯ изучаю Python.\nЯ уже прошел много тем, а сейчас я прохожу строки.")
S="python"
S2=S * 7
S3=S + S2
print(S,"\n",S2,"\n",S3)

s=input()
f=s[0]
l=s[-1]
n=s[1:-1]

print(l + n + f)

s=input()
ns=s[::-1]
print(s,'->',ns)

s=input()
s1=s.find(' ')
fw=s[:s1]
s2=s.rfind(' ')
sw=s[s1+1:s2]
tw=s[s2+1:]
ns=sw.replace('a','A')
print(fw.count('a'))
print(ns)
print(len(tw))

def shifr(plaintext, key):
    alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
    ciphrtext=""
    for letter in plaintext:
        new_letter = (alphabet.find(letter.lower()) +key % len(alphabet))
        ciphrtext=ciphrtext + alphabet[new_letter]
    return ciphrtext
def deshifr(plaintext, key):
    alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
    ciphrtext=""
    for letter in plaintext:
        new_letter = (alphabet.find(letter.lower()) -key % len(alphabet))
        ciphrtext=ciphrtext + alphabet[new_letter]
    return ciphrtext
while True:
    print('1 or 0?')
    g=input()
    if g=='1':
        word=input('слово ')
        k=int(input('сдвиг '))
        print(shifr(word, k))
    if g=='0':
        word=input('слово ')
        k=int(input('сдвиг '))
        print(deshifr(word, k))
    print('Continue?')
    x=input()
    if x!='yes':
        break

s=input()
if s.lower()=='up':
    print(s.upper())
elif s.lower()=='down':
    print(s.lower())
else:
    print('EROR')
s=input()
if s.isupper()==False and s.islower()==False and s.isalnum()==True and s.isalpha()==False and s.isdigit()==False:
    print('good')
else:
    print('bad')

a=int(input())
if a>2 and a%2==0:
    print('YES')
else:
    print('NO')
    
k=0
n=int(input())
for i in range(n):
    a=input()
    if a=='Tetrahedron':
        k+=4
    if a=='Cube':
        k+=6
    if a=='Octahedron':
        k+=8
    if a=='Dodecahedron':
        k+=12
    if a=='Icosahedron':
        k+=20
print(k)

m=0
nm=0
a=input().split()
k=int(a[0])
s=int(a[1])
m=min(k,s)
nm=abs(k-s)
print(m,nm//2)

q=int(input())
for i in range(q):
    n,a,b=[int(k) for k in input().split()]
    if b<a*2:
        m=n//2
        s=b*m
        if n%2!=0:
            s+=a
    else:
        s=n*a
    print(s)

a=['*10','//10','/10','%10','*1','//1','/1','%1']
b=['*10','//10','/10','%10','*1','//1','/1','%1']
from tkinter import *
from random import randint
def intDivBy10():                  
    global numF
    numF //= 10
    num.config(text=str(numF))
def modOper10():                  
    global numF
    numF %= 10
    num.config(text=str(numF))
def divBy10():                  
    global numF
    numF /= 10
    num.config(text=str(numF))
def mulBy10():                  
    global numF
    numF *= 10
    num.config(text=str(numF))
def intDivBy1():                  
    global numF
    numF //= 1
    num.config(text=str(numF))
def modOper1():                  
    global numF
    numF %= 1
    num.config(text=str(numF))
def divBy1():                  
    global numF
    numF /= 1
    num.config(text=str(numF))
def mulBy1():                  
    global numF
    numF *= 1
    num.config(text=str(numF))
def cancelOper():
    global numF
    global numF01
    numF = numF01
    num.config(text=str(numF))




    
def a1():                  
   if numF==a[0]:
       num.config(text='YES')
def a2():                  
    fhg
def a3():                  
   fgh
def a4():                  
  fgh
def a5():                  
   fgh
def a6():                  
    fgh
def a7():                  
   fgh
def a8():
    fgh
root = Tk()
root.geometry('460x300')
root.title('N-я цифра числа')
numF=a[randint(0, 7)]
numF01=numF
num=Label(root, text=str(numF), font='Verdana 48')
num.grid()
btn10_1 = Button(root, text='// 10', width=7, font='Verdana 18', command=intDivBy10)
btn10_1.grid()
btn10_2 = Button(root, text='% 10', width=7, font='Verdana 18', command=modOper10)
btn10_2.grid()
btn10_3= Button(root, text='/ 10', width=7, font='Verdana 18', command=divBy10)
btn10_3.grid()
btn10_4 = Button(root, text='* 10', width=7, font='Verdana 18', command=mulBy10)
btn10_4.grid()
btn1_1 = Button(root, text='// 1', width=7, font='Verdana 18', command=intDivBy1)
btn1_1.grid()
btn1_2 = Button(root, text='% 1 ', width=7, font='Verdana 18', command=modOper1)
btn1_2.grid()
btn1_3 = Button(root, text='/ 1 ', width=7, font='Verdana 18', command=divBy1)
btn1_3.grid()
btn1_4 = Button(root, text='* 1 ', width=7, font='Verdana 18', command=mulBy1)
btn1_4.grid()
btn_cancel = Button(root, text='Отмена', font='Verdana 18',
 command=cancelOper)
btn_cancel.grid()

def player_move(event):
    x=y=0
    key=event.keysym
    if key=="Up":
        y=-4
    if key=="Down":
        y=4
    if key=="Left":
        x=-4
    if key=="Right":
        x=4
    cv.move(player,x,y)
    for wall in walls:
        if player in cv.find_overlapping(wall[0], wall[1], wall[2], wall[3]):
            cv.move(player,-x,-y)
    for e in exits:
        if player in cv.find_overlapping(e[0], e[1], e[2], e[3]):
            cv.create_text(400, 350, text='WIN!',fill='purple')

        
        
    
from tkinter import *
w=Tk()
w.title('labs')
cv=Canvas(w, height=304, width=480)
cv.pack()
level=["wwwwwwwwwwwwwwwwwwwwwwwww",
       "w                       w",
       "wwww ww wwwwwwwwww w    w",
       "wwww wwwwwwwwwwww    ww w",
       "w  w wwwwwwwwww    w wwww",
       "w ww www    ww ww  www ww",
       "     wwwww wwww    wwwwww",
       "www  www    w     wwwwwww",
       "w    wwwwww   ww   wwwwww",
       "wwww wwwwwwwwwww   wwwwww",
       "wwww wwwwwwwwwww   wwwwww",
       "w                  wwwwww",
       "ww  wwwwwwwwwwwwwwwwwwwww",
       "wweewwwwwwwwwwwwwwwwwwwww"]

player=cv.create_rectangle(17,17,31,31,fill='lime')
walls=[]
exits=[]
x=0
y=0
for i in level:
    for m in i:
        if m=='w':
            cv.create_rectangle(x,y,x+16,y+16,fill='black')
            walls.append((x,y,x+16,y+16))
        if  m=='e':
            cv.create_rectangle(x,y,x+16,y+16,fill='red')
            exits.append((x,y,x+16,y+16))    
        x+=16
    y+=16
    x=0
cv.bind_all('<Key>', player_move)
from math import ceil
m, n=[int(i) for i in input().split()]
x=m*n
y=x//2
print(y)
x=0
n=int(input())
for i in range(n):
    c=input()
    if '+' in c:
        x+=1
    elif '-' in c:
        x-=1
print(x)

m, n=[int(i) for i in input().split()]
for i in range(n):
    if str(m)[-1]=='0':
        m=m//10
    else:
        m-=1
print(m)

from math import ceil
m, o, c=[int(i) for i in input().split()]
s, a, b=[int(i) for i in input().split()]
n=int(input())
g=m+o+c
h=s+a+b
x=ceil(g/5)
y=ceil(h/10)
j=x+y
if j>n:
    print('NO')
else:
    print('YES')
'''
n=int(input())
print(25)













