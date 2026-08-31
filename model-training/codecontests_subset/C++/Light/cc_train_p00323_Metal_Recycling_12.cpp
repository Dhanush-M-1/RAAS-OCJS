#include<bits/stdc++.h>
using namespace std;

int n;
int s[200020];

int main(){
  scanf("%d",&n);
  for(int i=0;i<n;i++){
    int x,y;
    scanf("%d %d",&x,&y);
    
    int z=x+y;
    while(s[z]){
      s[z]=0;
      z++;
    }
    s[z]=1;
  }
  for(int z=0;z<200020;z++)
    if(s[z])printf("%d 0\n",z);
  return 0;
}