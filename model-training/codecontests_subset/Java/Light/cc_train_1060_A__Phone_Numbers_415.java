n = +readline();
eight = 0;
readline().split('').map(Number).forEach(x=>{
   if (x === 8) eight++; 
});
print(Math.min(eight,Math.floor(n/11)));