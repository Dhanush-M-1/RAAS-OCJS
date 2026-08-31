#include<bits/stdc++.h>
using namespace std;

int main(){
  while(1){
    int word[5]={5,7,5,7,7},n;
  cin>>n;
  if(n==0) break;
  string str[41];
  for(int i=1;i<=n;i++)
    cin>>str[i];
  for(int i=1;i<n;i++){
    int x=0,cnt=str[i].size();
    if(cnt==word[x])x++,cnt=0;
    for(int j=i+1;j<=n;j++){
      cnt+=str[j].size();
      if(cnt==word[x])x++,cnt=0;
      if(x==5) break;
    }
      if(x==5){cout<<i<<endl;break;}
  }
  }
  return 0;
}
    