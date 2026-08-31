var n=parseInt(readline()),d=[],k,i,j;

var forbiddenWord = (""+Infinity)[2] + "or";

eval(forbiddenWord+"(i=0;i<n;i++) { d[i]=readline().split(' ')}");

eval(forbiddenWord+"(k=0;k<n;k++) { "+forbiddenWord+" (i=0;i<n;i++) { "+forbiddenWord+" (j=0; j<n; j++) { d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]) } } }");

k = d[0][0];
eval("f" + "or (i=0;i<n;i++) { "+forbiddenWord+" (j=0;j<n;j++) { k = Math.max(k, d[i][j]); } }");

print(k);
