#include<stdio.h>
#include<string.h>
int main(){
  int num,n,c,i,k;
  char s[5];
  int data[4][14]={0};
  char mark[]="SHCD";
  scanf("%d",&num);
  for(i=0;i<num;i++){
    scanf("%s",s);
    scanf("%d",&n);
    if(strcmp(s,"S")==0)c=0;
    else if(strcmp(s,"H")==0)c=1;
    else if(strcmp(s,"C")==0)c=2;
    else c=3;
    data[c][n]++;
  }
  for(i=0;i<4;i++){
    for(k=1;k<14;k++){
      if(!data[i][k])printf("%c %d\n",mark[i],k);
    }
  }
  return 0;
}