#include<bits/stdc++.h>
#define Pasharin using namespace std

Pasharin;
int main(){
  int n;
  int a[]={5,7,5,7,7};
  while(cin>>n,n){
    string s[n];
    int x=0,y=0;
    for(int i=0;i<n;++i) cin>>s[i];
    int j=0;
    bool flag=false;
    for(j=0;j<n;++j){
      for(int i=j;i<n;++i){
        x+=(int)s[i].size();
        if(x==a[y]){
          x=0;
          y++;
          if(y==5){
            cout<<j+1<<endl;
            flag=true;
            break;
          }
        }
        else if(x>a[y]){
          x=0,y=0;
          break;
        }
      }
      if(flag) break;
    }
  }
  return 0;
}