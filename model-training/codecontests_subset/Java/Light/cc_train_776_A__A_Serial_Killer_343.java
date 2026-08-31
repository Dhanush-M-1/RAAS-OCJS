'use strict'
let checkArr=readline();
let arrlength=parseInt(readline());
let serialKillers=['ross joey','rachel phoebe','phoebe monica','monica chandler']
   print(checkArr);
for (let i = 0; i < arrlength; i++) {
  let checker=checkArr.split(' ');
  let current = readline().split(' '),result='';
   if(checker[0]==current[0]){ result=current[1]+' '+checker[1];}
   else if(checker[0]==current[1]){result=current[0]+' '+checker[1];}
   else if(checker[1]==current[0]){ result=checker[0]+' '+current[1];}
   else{result=checker[0]+' '+current[0];}
   checkArr=result;
   print(result);
}
