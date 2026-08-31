#include<bits/stdc++.h>
using namespace std;
int main(){
  while(1){
    int n;
    cin>>n;
    if(n==0){
      break;
    }
    int leg[2]={},last=0,ans=0;
    string s;
    for(int i=0;i<n;i++){
      cin>>s;
      if(s=="lu"){
        leg[0]=1;
      }else if(s=="ru"){
        leg[1]=1;
      }else if(s=="ld"){
        leg[0]=0;
      }else{
        leg[1]=0;
      }
      if(leg[0]==leg[1]&&leg[0]!=last){
        ans++;
        last=leg[0];
      }
    }
    cout<<ans<<endl;
  }
  return 0;
}
