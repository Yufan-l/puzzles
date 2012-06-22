'''
Created on Apr 21, 2012

@author: yliu0
'''
ori_num=int(raw_input())
initial=4
high=initial+ori_num-1
star=1
arr=[]

for i in range(ori_num):
    for j in range(initial):
        arr.append(star)
        star+=2
    if i%2==0:
        star-=4
    else:
        star-=6
    initial+=1
    

#print arr

mid=arr[len(arr)-1]/2+1
   

    
       
for i in arr:
    s=""
    for j in range(mid-(i/2+1)):
        s+=" "
    for k in range(i):
        s+="*"
    print s

line=0

if ori_num%2==0:
    line=ori_num+1
else:
    line=ori_num    
           
for i in range(ori_num):
    s=""
    for j in range(mid-(line/2+1)):
        s+=" "
    for k in range(line):
        s+="|"
    print s
    
    