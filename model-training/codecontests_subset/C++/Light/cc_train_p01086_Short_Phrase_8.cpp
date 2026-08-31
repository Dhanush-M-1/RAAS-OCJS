#include<bits/stdc++.h>
using namespace std;
int f[]={5,7,5,7,7};
int n;
int t[50];
string str;

int solve(){
  for(int i=0;i<n;i++){
    int a=i,j;
    for(j=0;j<5;j++){
      int b=0;
      while(b<f[j])b+=t[a++];
      if(b>f[j])break;
    }
    if(j==5)return i;
  }
  return 0;
}

int main(){
  while(1){
    cin>>n;
    if(n==0)break;
    for(int i=0;i<n;i++){
      cin>>str;
      t[i]=str.size();
    }
    cout<<solve()+1<<endl;
  }
  return 0;
}