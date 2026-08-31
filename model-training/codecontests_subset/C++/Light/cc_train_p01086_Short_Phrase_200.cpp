#include<iostream>
#include<algorithm>
#include<string.h>
#include<stdio.h>
using namespace std;

int main(){
  int n,wa[41],flag[5];
  char s[40][20];
  while(1){
    cin>>n;
    if(n==0)
      break;
    wa[0]=0;
    for(int i=0;i<n;i++){
      scanf("%s",s[i]);
      wa[i+1]=strlen(s[i])+wa[i];
    }
    for(int i=0;i<n-1;i++){
      for(int j=0;j<5;j++)
        flag[j]=0;
      for(int k=i;k<=n;k++){
        if(wa[k]-wa[i]==5)
          flag[0]=1;
        else if(wa[k]-wa[i]==12)
          flag[1]=1;
        else if(wa[k]-wa[i]==17)
          flag[2]=1;
        else if(wa[k]-wa[i]==24)
          flag[3]=1;
        else if(wa[k]-wa[i]==31)
          flag[4]=1;
      }
      if(flag[0]==1&&flag[1]==1&&flag[2]==1&&flag[3]==1&&flag[4]==1){
        cout<<i+1<<endl;
        break;
      }
    }
  }
}
